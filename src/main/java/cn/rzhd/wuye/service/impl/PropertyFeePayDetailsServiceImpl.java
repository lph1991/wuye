package cn.rzhd.wuye.service.impl;

import cn.rzhd.wuye.bean.PropertyFeePayDetails;
import cn.rzhd.wuye.common.UpdateToERP;
import cn.rzhd.wuye.mapper.PropertyFeePayDetailsMapper;
import cn.rzhd.wuye.service.IPropertyFeePayDetailsService;
import cn.rzhd.wuye.vo.FeeVO;
import cn.rzhd.wuye.vo.LiandoServiceConstant;
import cn.rzhd.wuye.vo.query.PropertyFeePayDetailsQuery;
import cn.rzhd.wuye.vo.query.PropertyRecordsQuery;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by hasee on 2017/6/1.
 */
@Service
public class PropertyFeePayDetailsServiceImpl implements IPropertyFeePayDetailsService {

    @Autowired
    PropertyFeePayDetailsMapper mapper;

    /**
     * @param query 必须包含房产信息主键(houseInfoId),同时包含或不包含查询时间段,包含分页信息
     * @return
     */
    @Override
    public List<PropertyFeePayDetails> queryAll(PropertyFeePayDetailsQuery query) {
        if (StringUtil.isNotEmpty(query.getStartDate()) && StringUtil.isNotEmpty(query.getEndDate())) {
            return mapper.queryAll(query);
        }
        return null;
    }

    @Override
    public void addDetails(PropertyFeePayDetails details) {
        mapper.insert(details);
    }

    @Override
    public void changeStatus(Long id) {
        mapper.changeStatus(id);
    }

    @Override
    public List<Map<String, Object>> getByProject(PropertyRecordsQuery query) {
        return mapper.getByProject(query);
    }

    @Override
    public List<PropertyFeePayDetails> queryByProject(PropertyRecordsQuery query) {
        return mapper.queryByProject(query);
    }

    @Override
    public String getCostType(String feeType, String pk_corp) {
        return mapper.getCostType(feeType, pk_corp);
    }

    @Override
    public String getCompanyAccount(String feeType, String pk_corp) {
        return mapper.getCompanyAccount(feeType, pk_corp);
    }

    @Override
    public String getCompanyAccount(String pk_feeType) {
        return mapper.getCompanyAccountByPkFeeType(pk_feeType);
    }

    @Override
    public String getCompanyName(String feeType, String pk_corp) {
        return mapper.getCompanyName(feeType, pk_corp);
    }

    @Override
    public String getCompanyName(String pk_feeType) {
        return mapper.getCompanyNameByPkFeeType(pk_feeType);
    }

    @Override
    public Integer countByQuery(PropertyRecordsQuery query) {
        return mapper.countByQuery(query);
    }

    @Override
    public void changeStatusByRecordsId(String id) {
        mapper.changeStatusByRecordsId(id);
    }

    @Override
    public void updateToERP(String id) {
        List<String> ids = mapper.getPropertyFeeIdByRecords(id);
        if (!ids.isEmpty()) {
            List<FeeVO> list = mapper.getFeeDataByRecordsId(id);
            Map<String, String> map = UpdateToERP.updateToERP(list,LiandoServiceConstant.DATA_TYPE_WY_FEE);
            String billid = map.get("billid");
            String billno = map.get("billno");
            mapper.updateBillIdByRecordsId(id, billid, billno);
        } else {
            List<FeeVO> list = mapper.getTempFeeByRecords(id);
            Map<String, String> map = UpdateToERP.updateToERP(list,LiandoServiceConstant.DATA_TYPE_TEMP_RECEIPT);
            String billid = map.get("billid");
            String billno = map.get("billno");
            mapper.updateBillIdByRecordsId(id, billid, billno);
        }
    }
}
