package cn.rzhd.wuye.bean;

import java.io.Serializable;

public class PropertyFee implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String pk_corp;
    private String pk_customerid;
    private String pk_project;
    private String pk_house;
    private String pk_receivablesid;
    private String pk_feetype;
    private String feetype;
    private String actmonth;
    private String dbegin;
    private String dend;
    private String dshpay;
    private String vmemo;
    private String nyshouldmny;
    public String getPk_corp() {
        return pk_corp;
    }
    public void setPk_corp(String pk_corp) {
        this.pk_corp = pk_corp;
    }
    public String getPk_customerid() {
        return pk_customerid;
    }
    public void setPk_customerid(String pk_customerid) {
        this.pk_customerid = pk_customerid;
    }
    public String getPk_project() {
        return pk_project;
    }
    public void setPk_project(String pk_project) {
        this.pk_project = pk_project;
    }
    public String getPk_house() {
        return pk_house;
    }
    public void setPk_house(String pk_house) {
        this.pk_house = pk_house;
    }
    public String getPk_receivablesid() {
        return pk_receivablesid;
    }
    public void setPk_receivablesid(String pk_receivablesid) {
        this.pk_receivablesid = pk_receivablesid;
    }
    public String getPk_feetype() {
        return pk_feetype;
    }
    public void setPk_feetype(String pk_feetype) {
        this.pk_feetype = pk_feetype;
    }
    public String getFeetype() {
        return feetype;
    }
    public void setFeetype(String feetype) {
        this.feetype = feetype;
    }
    public String getActmonth() {
        return actmonth;
    }
    public void setActmonth(String actmonth) {
        this.actmonth = actmonth;
    }
    public String getDbegin() {
        return dbegin;
    }
    public void setDbegin(String dbegin) {
        this.dbegin = dbegin;
    }
    public String getDend() {
        return dend;
    }
    public void setDend(String dend) {
        this.dend = dend;
    }
    public String getDshpay() {
        return dshpay;
    }
    public void setDshpay(String dshpay) {
        this.dshpay = dshpay;
    }
    public String getVmemo() {
        return vmemo;
    }
    public void setVmemo(String vmemo) {
        this.vmemo = vmemo;
    }
    public String getNyshouldmny() {
        return nyshouldmny;
    }
    public void setNyshouldmny(String nyshouldmny) {
        this.nyshouldmny = nyshouldmny;
    }

}