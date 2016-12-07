package com.fpds.entity;

import java.util.Date;

import org.springframework.util.Assert;

public class QualityExposure {
    private String id;

    private String companyName;

    private String location;

    private String productName;

    private String brand;

    private String model;

    private String batch;

    private String result;

    private String reason;

    private String accreditationBody;

    private Integer productClass1;

    private String productClass1Name;

    private Integer productClass2;

    private String productClass2Name;

    private Date createTime;

    private Integer is;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getAccreditationBody() {
        return accreditationBody;
    }

    public void setAccreditationBody(String accreditationBody) {
        this.accreditationBody = accreditationBody == null ? null : accreditationBody.trim();
    }

    public Integer getProductClass1() {
        return productClass1;
    }

    public void setProductClass1(Integer productClass1) {
        this.productClass1 = productClass1;
    }

    public String getProductClass1Name() {
        return productClass1Name;
    }

    public void setProductClass1Name(String productClass1Name) {
        this.productClass1Name = productClass1Name == null ? null : productClass1Name.trim();
    }

    public Integer getProductClass2() {
        return productClass2;
    }

    public void setProductClass2(Integer productClass2) {
        this.productClass2 = productClass2;
    }

    public String getProductClass2Name() {
        return productClass2Name;
    }

    public void setProductClass2Name(String productClass2Name) {
        this.productClass2Name = productClass2Name == null ? null : productClass2Name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIs() {
        return is;
    }

    public void setIs(Integer is) {
        this.is = is;
    }
    
    public void check(){
    	Assert.isNull(companyName,"不能为空");
    	Assert.isNull(location,"不能为空");
    	Assert.isNull(productName,"不能为空");
    	Assert.isNull(brand,"不能为空");
    	Assert.isNull(model,"不能为空");
    	Assert.isNull(batch,"不能为空");
    	Assert.isNull(result,"不能为空");
//    	Assert.isNull(reason,"不能为空");
//    	Assert.isNull(accreditationBody,"不能为空");
    	Assert.isNull(productClass1,"不能为空");
    	Assert.isNull(productClass1Name,"不能为空");
    	Assert.isNull(productClass2,"不能为空");
    	Assert.isNull(productClass2Name,"不能为空");
    	Assert.isNull(createTime,"不能为空");
    	Assert.isNull(is,"不能为空");
    }
    
}