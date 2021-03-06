package cn.rzhd.wuye.controller;

import cn.rzhd.wuye.bean.*;
import cn.rzhd.wuye.service.*;
import cn.rzhd.wuye.vo.query.ApplyQuery;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xiaoleilu.hutool.util.NumberUtil;
import com.xiaoleilu.hutool.util.RandomUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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
    //房产信息
    @Autowired
    IHouseInfoDetailsService houseInfoDetailsService;

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
     * 装修申请
     */
    @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> batchUpload(DecorationApply decorationApply) {
        System.out.println("decorationApply = " + decorationApply);
        Map<String, String> result = new HashMap<>();
        Date date = new Date();
        Long aLong = Long.valueOf(RandomUtil.randomNumbers(16));
        decorationApply.setDecorationApplyId(aLong);
        decorationApply.setAuditStatus(0);
        decorationApply.setIsSpecialDecoration(0);
        decorationApply.setOpinion("0");
        decorationApply.setApplyTime(date);
        decorationApply.setCreationTime(date);
        System.out.println("aLong = " + aLong);

        try {
            if (decorationApply.getDecorateArea() != null && decorationApply.getAntipateTime() != null) {
                //装修押金
                if (NumberUtil.compare(decorationApply.getDecorateArea(), 1000) == -1) {
                    decorationApply.setDecorationDeposit(new BigDecimal(5000.00));
                } else if (NumberUtil.compare(decorationApply.getDecorateArea(), 1000) != -1) {
                    decorationApply.setDecorationDeposit(new BigDecimal(10000.00));
                }

                //装修管理费
                decorationApply.setDecorationManagementCost(new BigDecimal(NumberUtil.mul(decorationApply.getDecorateArea(), 3)));
                //出入证工本费
                decorationApply.setPassPapersCost(new BigDecimal(NumberUtil.mul(decorationApply.getConstructPeopleNumber(), 10)));
                //出入证押金
                decorationApply.setPassPapersDeposit(new BigDecimal(NumberUtil.mul(decorationApply.getConstructPeopleNumber(), 10)));
                //装修申请
                System.out.println("ndecorationApply = " + decorationApply + "/n");
                decorationApplyService.insert(decorationApply);
                for (int i = 0; i < decorationApply.getDecorateDetailList().size(); i++) {
                    DecorateDetail decorateDetail = new DecorateDetail();
                    decorateDetail.setDecorationApplyId(aLong);
                    decorateDetail.setDecorateDetailId(Long.valueOf(RandomUtil.randomNumbers(16)));
                    decorateDetail.setDetailOrder(decorationApply.getDecorateDetailList().get(i).getDetailOrder());
                    decorateDetail.setDetailContent(decorationApply.getDecorateDetailList().get(i).getDetailContent());
                    //装修明细
                    decorateDetailService.insert(decorateDetail);
                }
                for (int i = 0; i < decorationApply.getDecorationMaterialList().size(); i++) {
                    DecorationMaterial decorationMaterial = new DecorationMaterial();
                    decorationMaterial.setDecorationApplyId(aLong);
                    decorationMaterial.setDecorationMaterialId(Long.valueOf(RandomUtil.randomNumbers(16)));
                    decorationMaterial.setMaterialAddress(decorationApply.getDecorationMaterialList().get(i).getMaterialAddress());
                    decorationMaterial.setMaterialName(decorationApply.getDecorationMaterialList().get(i).getMaterialName());

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
        HouseInfoDetails houseInfoDetails = houseInfoDetailsService.selectByPkHouse(decorationApply.getHouseInfoId());
        houseInfoDetails.setDecorationapplystate("1");
        houseInfoDetailsService.updateHouse(String.valueOf(aLong), null, "1");
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
        //装修资料
        List<Map<String, JsonFormat.Value>> decorationMaterialList = decorationMaterialService.findByQuery(decorationApplyId);
        //装修明细
        List<DecorateDetail> decorateDetailList = decorateDetailService.selectByApplyKey(decorationApplyId);
        Map<String, Object> map = new HashMap<>();
        map.put("decorationApply", decorationApply);
        map.put("decorationMaterialList", decorationMaterialList);
        map.put("decorateDetailList", decorateDetailList);
        result.put("state", "1");
        result.put("data", map);
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
        Map<String, Object> map = new HashMap<>();
        if (decorationApply != null) {
            //装修资料
            List<Map<String, JsonFormat.Value>> decorationMaterialList = decorationMaterialService.findByQuery(decorationApply.getDecorationApplyId());
            //装修明细
            List<DecorateDetail> decorateDetailList = decorateDetailService.selectByApplyKey(decorationApply.getDecorationApplyId());
            map.put("decorationApply", decorationApply);
            map.put("decorationMaterialList", decorationMaterialList);
            map.put("decorateDetailList", decorateDetailList);
        }
        if (decorationApply != null) {
            result.put("state", "1");
            result.put("data", map);
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
    @RequestMapping("/updateDecorationApply")
    public String updateDecorationApply(DecorationApply decorationApply) {
        Map<String, String> result = new HashMap<>();
        if (decorationApply.getDecorationApplyId() == null) {
            result.put("state", "0");
            result.put("msg", "ID不能为空!");
        }

        int i = decorationApplyService.updateByPrimaryKey(decorationApply);
        if (i > 0) {
            //修改申请状态
            if (decorationApply.getAuditStatus() == 1) {
                houseInfoDetailsService.updateHouse(String.valueOf(decorationApply.getDecorationApplyId()), null, "2");
            }
            if (decorationApply.getAuditStatus() == 2) {
                houseInfoDetailsService.updateHouse(String.valueOf(decorationApply.getDecorationApplyId()), null, "0");
            }
            if (decorationApply.getAuditStatus() == 0) {
                houseInfoDetailsService.updateHouse(String.valueOf(decorationApply.getDecorationApplyId()), null, "0");
            }
        }
        System.out.println("i = " + i);
        result.put("state", "1");

        // return result;
        return "redirect:/dist/toDecorationApplyList";
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

    /**
     * 所有装修申请
     *
     * @param model
     * @return
     */
    @RequestMapping("/toDecorationApplyList")
    public String toDecorationApplyList(Model model) {
        List<Map<String, JsonFormat.Value>> decorationApplyList = decorationApplyService.findDecorationApplyList();
        model.addAttribute("decorationApply", decorationApplyList);
        return "decoration/decorationApplyList";
    }

    /**
     * 搜索
     *
     * @param query
     * @param model
     * @return
     */
    @RequestMapping("/decoration/search")
    public String enDecorationSearch(ApplyQuery query, Model model) {

        System.out.println("query = " + query);
        List<Map<String, JsonFormat.Value>> decorationApplyListByQuery = decorationApplyService.findDecorationApplyListByQuery(query);
        model.addAttribute("decorationApply", decorationApplyListByQuery);
        model.addAttribute("clientName", query.getClientName());
        model.addAttribute("startDate", query.getStartDate());
        model.addAttribute("endDate", query.getEndDate());
        return "decoration/decorationApplyList";
    }

    /**
     * 去往编辑页面
     *
     * @param model
     * @param decorationApplyId
     * @return
     */
    @RequestMapping("toDecorationApply")
    public String toDecorationApplyEdit(Model model, Long decorationApplyId) {
        //装修申请
        DecorationApply decorationApply = decorationApplyService.selectByPrimaryKey(decorationApplyId);
        //装修资料
        List<Map<String, JsonFormat.Value>> decorationMaterialList = decorationMaterialService.findByQuery(decorationApplyId);
        //装修明细
        List<DecorateDetail> decorateDetailList = decorateDetailService.selectByApplyKey(decorationApplyId);
        model.addAttribute("decorationApply", decorationApply);
        model.addAttribute("decorationMaterialList", decorationMaterialList);
        model.addAttribute("decorateDetailList", decorateDetailList);

        return "decoration/decorationApplyEdit";
    }

    /**
     * 删除装修申请信息
     *
     * @param decorationApplyId
     * @return
     */
    @RequestMapping("/deleteDecorationApplyByID")
    public String deleteDecorationApplyByID(Long decorationApplyId) {
        if (decorationApplyId != null) {
            DecorationApply decorationApply = decorationApplyService.selectByPrimaryKey(decorationApplyId);
            decorationApplyService.deleteByPrimaryKey(decorationApplyId);
            houseInfoDetailsService.updateHouse(String.valueOf(decorationApplyId), null, "0");
        }
        return "redirect:/dist/toDecorationApplyList";
    }

    /**
     * 完成装修流程
     *
     * @param decorationApplyId
     * @return
     */
    @RequestMapping("/updateDecorationApplyState")
    @ResponseBody
    public Map<String, String> updateDecorationApplyState(Long decorationApplyId) {
        Map<String, String> result = new Hashtable<>();
        try {
            houseInfoDetailsService.updateHouse(String.valueOf(decorationApplyId), null, "-1");
            result.put("state", "1");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.put("state", "0");
            result.put("msg", "erro" + e.getMessage());
            return result;
        }
    }

    /**
     * 获取是否已申请装修
     *
     * @param pkHouse
     * @param customerId
     * @return
     */
    @RequestMapping("/getDecorationApplyCount")
    @ResponseBody
    public Map<String, String> getCount(String pkHouse, String customerId) {
        Map<String, String> result = new Hashtable<>();
        if (StrUtil.isEmpty(pkHouse) && StrUtil.isEmpty(customerId)) {
            result.put("state", "0");
            result.put("msg", "ID为空");
            return result;
        }
        Integer count = decorationApplyService.getCount(pkHouse, customerId);
        result.put("state", "1");
        result.put("data", count.toString());
        result.put("msg", "已经提交过申请");
        return result;
    }

    /**
     * 数据回显
     *
     * @param pkHouse
     * @param customerId
     * @return
     */
    @RequestMapping("/getDecorationApplyByOrder")
    @ResponseBody
    public Map<String, String> getDecorationApplyByOrder(String pkHouse, String customerId) {
        Map<String, String> result = new Hashtable<>();
        if (StrUtil.isEmpty(pkHouse) && StrUtil.isEmpty(customerId)) {
            result.put("state", "0");
            result.put("msg", "ID为空");
            return result;
        }
        DecorationApply decorationApply = decorationApplyService.getDecorationApplyByOrder(pkHouse, customerId);
        String jsonString = JSON.toJSONString(decorationApply);
        result.put("state", "1");
        result.put("data", jsonString);
        return result;
    }

    @RequestMapping("decorationMateria/todecorationMateria")
    public String todecorationMateria() {

        return "decoration/decorationMaterialList";
    }

}
