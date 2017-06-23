package cn.rzhd.wuye.controller;

import cn.rzhd.wuye.bean.*;
import cn.rzhd.wuye.bean.vo.ResousVO;
import cn.rzhd.wuye.service.*;
import cn.rzhd.wuye.utils.IDUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * luopa 在 2017/6/7 创建.
 * <p>
 * 装修申请
 */
@Controller
@RequestMapping("/dist")
public class DecorationApplyController {
    //装修须知
    @Autowired
    IDecorationNoticeService decorationNoticeService;
    //装修明细
    @Autowired
    IDecorateDetailService decorateDetailService;
    //装修资料
    @Autowired
    IDecorationMaterialService decorationMaterialService;
    //装修申请
    @Autowired
    IDecorationApplyService decorationApplyService;
    //房产服务
    @Autowired
    IHouseInfoService houseInfoService;

    /**
     * 装修须知
     *
     * @return
     */
    @RequestMapping("/decorationNotice/list")
    @ResponseBody
    public String selectAll() {
        List<DecorationNotice> decorationNotices = decorationNoticeService.selectAll();
        DecorationNotice decorationNotice = null;
        String jsonString = "没有数据!";
        if (decorationNotices.size() > 0) {
            decorationNotice = decorationNotices.get(0);
            jsonString = JSON.toJSONString(decorationNotice, SerializerFeature.WriteMapNullValue);
        }
        return jsonString;
    }


    /**
     * 装修资料
     */
    //public List<Map<String, Value>>

    /**
     * 装修申请
     */
    @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> batchUpload(@RequestBody ResousVO resousVO) {
        System.out.println("resousVO = " + resousVO);
        Map<String, String> result = new HashMap<>();
        Date date = new Date();
        DecorationApply decorationApply = new DecorationApply();
        Long aLong = IDUtils.genLongUID();
        decorationApply.setDecorationApplyId(aLong);
        decorationApply.setAuditStatus(0);
        decorationApply.setIsSpecialDecoration(0);
        decorationApply.setApplyTime(date);
        decorationApply.setCreationTime(date);
        System.out.println("aLong = " + aLong);
        try {
            if (decorationApply.getDecorateArea() != null) {
                //装修押金
                if (decorationApply.getDecorateArea() < 1000) {
                    decorationApply.setDecorationDeposit(new BigDecimal(5000.00));
                } else if (decorationApply.getDecorateArea() >= 1000) {
                    decorationApply.setDecorationDeposit(new BigDecimal(10000.00));
                }
                //装修管理费
                decorationApply.setDecorationManagementCost(new BigDecimal(decorationApply.getDecorateArea() * 3));
                //出入证工本费
                decorationApply.setPassPapersCost(new BigDecimal(decorationApply.getConstructPeopleNumber() * 10));
                //出入证押金
                decorationApply.setPassPapersDeposit(new BigDecimal(decorationApply.getConstructPeopleNumber() * 10));
                //装修申请
                decorationApplyService.insert(decorationApply);
                for (int i = 0; i < resousVO.getDecorateDetailList().size(); i++) {
                    DecorateDetail decorateDetail = new DecorateDetail();
                    decorateDetail.setDecorationApplyId(aLong);
                    decorateDetail.setDecorateDetailId(IDUtils.genLongUID());
                    decorateDetail.setDetailOrder(i + 1L);
                    decorateDetail.setDetailContent(resousVO.getDecorateDetailList().get(i).getDetailContent());
                    //装修明细
                    decorateDetailService.insert(decorateDetail);
                }
                for (int i = 0; i < resousVO.getDecorationMaterialList().size(); i++) {
                    DecorationMaterial decorationMaterial = new DecorationMaterial();
                    decorationMaterial.setDecorationApplyId(aLong);
                    decorationMaterial.setDecorationMaterialId(IDUtils.genLongUID());
                    decorationMaterial.setMaterialAddress(resousVO.getDecorationMaterialList().get(i).getMaterialAddress());
                    decorationMaterial.setMaterialName(resousVO.getDecorationMaterialList().get(i).getMaterialName());
                    //装修资料
                    decorationMaterialService.insert(decorationMaterial);
                }
            } else {
                result.put("state", "0");
                result.put("msg", "申请失败 数据不完整");
                return result;
            }
        } catch (Exception e) {
            result.put("state", "0");
            result.put("msg", "申请失败" + e.getMessage());
            return result;
        }
        //修改申请状态
        HouseInfo houseInfo = houseInfoService.getById(resousVO.getDecorationApply().getHouseInfoId());
        houseInfo.setDecorationApplyState("1");
        houseInfoService.update(houseInfo);
        result.put("state", "1");
        result.put("msg", "申请成功");
        return result;
    }

    /**
     * 查询审核结果
     *
     * @param decorationApplyId
     * @return
     */
    @ResponseBody
    @RequestMapping("/findDecorationApplyByID")
    public Map<String, Object> findDecorationApplyByID(Long decorationApplyId) {
        Map<String, Object> result = new HashMap<>();
        if (decorationApplyId == null) {
            result.put("state", "0");
            result.put("msg", "ID不能为空!");
            return result;
        }
        DecorationApply decorationApply = decorationApplyService.selectByPrimaryKey(decorationApplyId);
        result.put("state", "1");
        result.put("data", decorationApply);
        return result;
    }

    /**
     * 根据房产编码查询审核结果
     *
     * @param houseInfoId
     * @return
     */
    @ResponseBody
    @RequestMapping("/findDecorationApplyByHouseId")
    public Map<String, Object> findDecorationApplyByHouseId(String houseInfoId) {
        Map<String, Object> result = new HashMap<>();
        if (houseInfoId == null) {
            result.put("state", "0");
            result.put("msg", "ID不能为空!");
            return result;
        }
        DecorationApply decorationApply = decorationApplyService.findDecorationApplyByHouseId(houseInfoId);
        if (decorationApply != null) {
            result.put("state", "1");
            result.put("data", decorationApply);
        } else if (decorationApply == null) {
            result.put("state", "0");
            result.put("data", "null");
        } else {
            result.put("state", "0");
            result.put("msg", "错误");
        }
        return result;
    }

    /**
     * 审核装修申请
     *
     * @param decorationApply
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateDecorationApply")
    public Map<String, String> updateDecorationApply(DecorationApply decorationApply) {
        Map<String, String> result = new HashMap<>();
        if (decorationApply.getDecorationApplyId() == null) {
            result.put("state", "0");
            result.put("msg", "ID不能为空!");
            return result;
        }

        int i = decorationApplyService.updateByPrimaryKey(decorationApply);
        if (i > 0) {
            //修改申请状态
            HouseInfo houseInfo = houseInfoService.getById(decorationApply.getHouseInfoId());
            houseInfo.setDecorationApplyState("2");
            houseInfoService.update(houseInfo);
        }
        System.out.println("i = " + i);
        result.put("state", "1");

        return result;
    }

    /**
     * 获取所有装修申请
     *
     * @return
     */
    @RequestMapping(value = "/findList")
    @ResponseBody
    public String findList() {
        List<Map<String, JsonFormat.Value>> decorationApplyList =
                decorationApplyService.findDecorationApplyList();
        String jsonString = JSON.toJSONString(decorationApplyList);
        return jsonString;
    }

    /**
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Map<String, String> result = new HashMap<>();

        String savePath = request.getServletContext().getRealPath("/upload/");
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy_MM_dd");// 设置日期格式
        SimpleDateFormat df2 = new SimpleDateFormat("HH_mm_ss_SSSS");// 设置日期格式
        String dateDir1 = df1.format(new Date());// new Date()为获取当前系统时间
        String dateDir2 = df2.format(new Date());// new Date()为获取当前系统时间
        String serviceName = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        File tempFile = new File(savePath + dateDir1 + "/" + dateDir2 + File.separator + serviceName);
        String path = "/upload/" + dateDir1 + "/" + dateDir2 + File.separator + serviceName;
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdirs();
        }
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(tempFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                result.put("state", "0");
                result.put("msg", "文件找不到");
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                result.put("state", "0");
                result.put("msg", "上传失败," + e.getMessage());
                return result;
            }
            result.put("state", "1");
            result.put("msg", "上传成功");
            result.put("url", path);
            return result;
        } else {
            result.put("state", "0");
            result.put("msg", "上传失败，因为文件是空的");
            return result;
        }
    }

    @RequestMapping("/toDecorationApplyList")
    public String toDecorationApplyList(Model model) {
        List<Map<String, JsonFormat.Value>> decorationApplyList = decorationApplyService.findDecorationApplyList();
        model.addAttribute("decorationApply", decorationApplyList);
        return "decoration/decorationApplyList";
    }

    @RequestMapping("toDecorationApply")
    public String toDecorationApplyEdit(Model model, Long decorationApplyId) {
        DecorationApply decorationApply = decorationApplyService.selectByPrimaryKey(decorationApplyId);

        model.addAttribute("decorationApply", decorationApply);
        return "decoration/decorationApplyEdit";
    }


}
