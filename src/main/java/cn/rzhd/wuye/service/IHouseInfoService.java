package cn.rzhd.wuye.service;

import cn.rzhd.wuye.bean.HouseInfo;

import java.util.List;

/**
 * Created by hasee on 2017/5/25.
 */
public interface IHouseInfoService {
    /**
     * 通过HouseInfoId查询获取本地存放的HouseInfo数据
     * @param houseInfoId
     * @return  返回HouseInfo对象
     */
    HouseInfo getById(String houseInfoId);
    /**
     * 获取HouseInfo所有记录
     * @return 返回HouseInfo的List
     */
    List<HouseInfo> getAll();

    /**
     * 保存房产信息
     * @param houseInfo
     */
    void add(HouseInfo houseInfo);

    /**
     * 修改房产信息
     * @param houseInfo
     */
    void update(HouseInfo houseInfo);

    /**
     * 删除房产信息
     * @param id
     */
    void delete(Long id);

    /**
     * 获取客户房产
     * @param customerid 客户ID
     * @return
     */
    HouseInfo selectByQuery(String customerid);
    
    /**
     * @return 后台返回房产信息
     */
    List<HouseInfo> getAllHouseinfo();
}
