package cn.rzhd.wuye.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hasee on 2017/6/1.
 */
public class KfFeePayDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 开发缴费详情id
     */
    private Long kfFeePayDetailsId;
    /**
     * 房产id
     */
    private String houseInfoId;
    /**
     * 客户名称
     */
    private String clientName;
    /**
     * 费用类型
     */
    private String costType;
    /**
     * 支付方式
     */
    private String payManner;
    /**
     * 缴费月份
     */
    private String payMonth;
    /**
     * 开始日期
     */
    private Date startDate;
    /**
     * 截止日期
     */
    private Date endDate;
    /**
     * 应缴
     */
    private BigDecimal payable;
    /**
     * 已缴
     */
    private BigDecimal paidIn;
    /**
     * 单据号
     */
    private String voucherNumber;
    /**
     * ERP所需发票ID
     */
    private String invoice;
    /**
     * 发票号
     */
    private String invoiceNumber;
    /**
     * 发票备注
     */
    private String invoiceNotes;
    /**
     * 开票状态(0-不开票，1-暂不开票,2-业主开票,3-代付开票,4-已开票)
     */
    private Integer invoiceStatus =1;
    /**
     * 收款公司
     */
    private String collectingCompany;
    /**
     * 收款账户
     */
    private String collectingAccount;
    /**
     * 开票公司
     */
    private String invoiceCompany;
    /**
     * 交费日期
     */
    private Date payTime;
    /**
     * 创建时间
     */
    private Date carteTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 客户主键
     */
    private String customerId;

    /**
     * 缴费记录是否生效(Y--生效,N--未生效)
     */
    private String status = "N";
    /**
     * 费用编码
     */
    private String feecode;
    /**
     * 缴费公司
     */
    private String pk_corp;
    /**
     * 付款记录ID
     */
    private String recordsId;
    /**
     * 收费项目主键
     */
    private String pk_feeType;
    /**
     * 开发费用数据ID
     */
    private String kfFeeId;

    public Long getKfFeePayDetailsId() {
        return kfFeePayDetailsId;
    }

    public void setKfFeePayDetailsId(Long kfFeePayDetailsId) {
        this.kfFeePayDetailsId = kfFeePayDetailsId;
    }

    public String getHouseInfoId() {
        return houseInfoId;
    }

    public void setHouseInfoId(String houseInfoId) {
        this.houseInfoId = houseInfoId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPayManner() {
        return payManner;
    }

    public void setPayManner(String payManner) {
        this.payManner = payManner;
    }

    public String getPayMonth() {
        return payMonth;
    }

    public void setPayMonth(String payMonth) {
        this.payMonth = payMonth;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPayable() {
        return payable;
    }

    public void setPayable(BigDecimal payable) {
        this.payable = payable;
    }

    public BigDecimal getPaidIn() {
        return paidIn;
    }

    public void setPaidIn(BigDecimal paidIn) {
        this.paidIn = paidIn;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNotes() {
        return invoiceNotes;
    }

    public void setInvoiceNotes(String invoiceNotes) {
        this.invoiceNotes = invoiceNotes;
    }

    public Integer getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getCollectingCompany() {
        return collectingCompany;
    }

    public void setCollectingCompany(String collectingCompany) {
        this.collectingCompany = collectingCompany;
    }

    public String getCollectingAccount() {
        return collectingAccount;
    }

    public void setCollectingAccount(String collectingAccount) {
        this.collectingAccount = collectingAccount;
    }

    public String getInvoiceCompany() {
        return invoiceCompany;
    }

    public void setInvoiceCompany(String invoiceCompany) {
        this.invoiceCompany = invoiceCompany;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getCarteTime() {
        return carteTime;
    }

    public void setCarteTime(Date carteTime) {
        this.carteTime = carteTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getFeecode() {
        return feecode;
    }

    public void setFeecode(String feecode) {
        this.feecode = feecode;
    }

    public String getPk_corp() {
        return pk_corp;
    }

    public void setPk_corp(String pk_corp) {
        this.pk_corp = pk_corp;
    }

    public String getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(String recordsId) {
        this.recordsId = recordsId;
    }

    public String getPk_feeType() {
        return pk_feeType;
    }

    public void setPk_feeType(String pk_feeType) {
        this.pk_feeType = pk_feeType;
    }

    public String getKfFeeId() {
        return kfFeeId;
    }

    public void setKfFeeId(String kfFeeId) {
        this.kfFeeId = kfFeeId;
    }
}
