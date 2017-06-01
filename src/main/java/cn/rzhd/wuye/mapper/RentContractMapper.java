package cn.rzhd.wuye.mapper;

import cn.rzhd.wuye.vo.PactVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by hasee on 2017/5/28.
 */
@Mapper
public interface RentContractMapper {
    /**
     * 通过租赁合同主键获得对应的租赁合同记录
     * @param pk_pact 租赁合同主键
     * @return 租赁合同载体对象
     */
    PactVO getById(String pk_pact);

    void add(PactVO pactVO);
}