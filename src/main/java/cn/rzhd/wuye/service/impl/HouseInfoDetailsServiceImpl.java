package cn.rzhd.wuye.service.impl;

import cn.rzhd.wuye.mapper.HouseInfoDetailsMapper;
import cn.rzhd.wuye.service.IHouseInfoDetailsService;
import cn.rzhd.wuye.vo.HouseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hasee on 2017/6/5.
 */
@Service
public class HouseInfoDetailsServiceImpl implements IHouseInfoDetailsService {

    @Autowired
    HouseInfoDetailsMapper mapper;

    @Override
    public void addHouseInfoDetails(HouseVO houseInfoDetails) {
        mapper.insert(houseInfoDetails);
    }

    @Override
    public void saveHouseInfoDetails(HouseVO houseInfoDetails) throws Exception {
        HouseVO one = mapper.selectByPrimaryKey(houseInfoDetails.getPk_house());
        if (one!=null){
            mapper.updateByPrimaryKey(houseInfoDetails);
        }else{
            mapper.insert(houseInfoDetails);
        }
    }
}