package cn.rzhd.wuye.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
© 2017 RZHD.CN
@Package: cn.rzhd.ldug.bean
@ClassName: RentPayDetails
@Description: 描述：租金缴费详情
@author: zhongchaojie@rzhd.cn
@date: 2017年5月23日 下午2:33:01
@version: V1.0
 */
public class RentPayDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 租金缴费详情id
	 */
	private Long rentPayDetailsId;
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
	private Integer payMonth;
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
	 * 发票
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
	 * 开票状态(0-已开，1-未开,2-不开)
	 */
	private Integer invoiceStatus;
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
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/*
	@param clientName the clientName to set
	*/
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * @return the costType
	 */
	public String getCostType() {
		return costType;
	}
	/*
	@param costType the costType to set
	*/
	public void setCostType(String costType) {
		this.costType = costType;
	}
	/**
	 * @return the payManner
	 */
	public String getPayManner() {
		return payManner;
	}
	/*
	@param payManner the payManner to set
	*/
	public void setPayManner(String payManner) {
		this.payManner = payManner;
	}
	/**
	 * @return the payMonth
	 */
	public Integer getPayMonth() {
		return payMonth;
	}
	/*
	@param payMonth the payMonth to set
	*/
	public void setPayMonth(Integer payMonth) {
		this.payMonth = payMonth;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/*
	@param startDate the startDate to set
	*/
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/*
	@param endDate the endDate to set
	*/
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the payable
	 */
	public BigDecimal getPayable() {
		return payable;
	}
	/*
	@param payable the payable to set
	*/
	public void setPayable(BigDecimal payable) {
		this.payable = payable;
	}
	/**
	 * @return the paidIn
	 */
	public BigDecimal getPaidIn() {
		return paidIn;
	}
	/*
	@param paidIn the paidIn to set
	*/
	public void setPaidIn(BigDecimal paidIn) {
		this.paidIn = paidIn;
	}
	/**
	 * @return the voucherNumber
	 */
	public String getVoucherNumber() {
		return voucherNumber;
	}
	/*
	@param voucherNumber the voucherNumber to set
	*/
	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}
	/**
	 * @return the invoice
	 */
	public String getInvoice() {
		return invoice;
	}
	/*
	@param invoice the invoice to set
	*/
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	/**
	 * @return the invoiceNumber
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	/*
	@param invoiceNumber the invoiceNumber to set
	*/
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	/**
	 * @return the invoiceNotes
	 */
	public String getInvoiceNotes() {
		return invoiceNotes;
	}
	/*
	@param invoiceNotes the invoiceNotes to set
	*/
	public void setInvoiceNotes(String invoiceNotes) {
		this.invoiceNotes = invoiceNotes;
	}
	/**
	 * @return the invoiceStatus
	 */
	public Integer getInvoiceStatus() {
		return invoiceStatus;
	}
	/*
	@param invoiceStatus the invoiceStatus to set
	*/
	public void setInvoiceStatus(Integer invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	/**
	 * @return the collectingCompany
	 */
	public String getCollectingCompany() {
		return collectingCompany;
	}
	/*
	@param collectingCompany the collectingCompany to set
	*/
	public void setCollectingCompany(String collectingCompany) {
		this.collectingCompany = collectingCompany;
	}
	/**
	 * @return the collectingAccount
	 */
	public String getCollectingAccount() {
		return collectingAccount;
	}
	/*
	@param collectingAccount the collectingAccount to set
	*/
	public void setCollectingAccount(String collectingAccount) {
		this.collectingAccount = collectingAccount;
	}
	/**
	 * @return the invoiceCompany
	 */
	public String getInvoiceCompany() {
		return invoiceCompany;
	}
	/*
	@param invoiceCompany the invoiceCompany to set
	*/
	public void setInvoiceCompany(String invoiceCompany) {
		this.invoiceCompany = invoiceCompany;
	}
	/**
	 * @return the payTime
	 */
	public Date getPayTime() {
		return payTime;
	}
	/*
	@param payTime the payTime to set
	*/
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	/**
	 * @return the carteTime
	 */
	public Date getCarteTime() {
		return carteTime;
	}
	/*
	@param carteTime the carteTime to set
	*/
	public void setCarteTime(Date carteTime) {
		this.carteTime = carteTime;
	}
	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/*
	@param updateTime the updateTime to set
	*/
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the rentPayDetailsId
	 */
	public Long getRentPayDetailsId() {
		return rentPayDetailsId;
	}
	/*
	@param rentPayDetailsId the rentPayDetailsId to set
	*/
	public void setRentPayDetailsId(Long rentPayDetailsId) {
		this.rentPayDetailsId = rentPayDetailsId;
	}

	public String getHouseInfoId() {
		return houseInfoId;
	}

	public void setHouseInfoId(String houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
}
