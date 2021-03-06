package cn.rzhd.wuye.mapper;

import cn.rzhd.wuye.bean.Invoice;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
@Mapper
public interface UtilitiesInvoiceMapper {
    int deleteByPrimaryKey(BigDecimal utilitiesInvoiceId);

    int insert(Invoice record);

    Invoice selectByPrimaryKey(BigDecimal utilitiesInvoiceId);

    List<Invoice> selectAll();

    int updateByPrimaryKey(Invoice record);

    void changeStatusByRecordsId(String id);
}