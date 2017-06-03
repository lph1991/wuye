package cn.rzhd.wuye.service;

import cn.rzhd.wuye.bean.WaterRatePayDetails;
import cn.rzhd.wuye.vo.WaterPayDetailsQuery;

import java.util.List;

/**
 * Created by hasee on 2017/6/2.
 * 通过封装好的查询条件对象获取符合的记录List
 */
public interface IWaterPayDetailsService {

    List<WaterRatePayDetails> getAllByQuery(WaterPayDetailsQuery query);
}
