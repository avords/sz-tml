package com.parkdt.tml.domain;

import java.io.Serializable;
import java.util.Date;

public class ProjectImporterInfo implements Serializable {
    private Long id;

    private Long memberId;

    private Short authenticationType;

    private Long companyId;

    private String theCompany;

    private String companyName;

    private String name;

    private String idCard;

    private Short gender;

    private Date birthday;

    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;

    private String address;

    private String email;

    private String phone;

    private Date createTime;

    private Date updateTime;

    private String jobTitle;

    private Short isProjectEditing;

    private Short isProjectEditingAndEditing;

    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Short getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(Short authenticationType) {
        this.authenticationType = authenticationType;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getTheCompany() {
        return theCompany;
    }

    public void setTheCompany(String theCompany) {
        this.theCompany = theCompany == null ? null : theCompany.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    public Short getIsProjectEditing() {
        return isProjectEditing;
    }

    public void setIsProjectEditing(Short isProjectEditing) {
        this.isProjectEditing = isProjectEditing;
    }

    public Short getIsProjectEditingAndEditing() {
        return isProjectEditingAndEditing;
    }

    public void setIsProjectEditingAndEditing(Short isProjectEditingAndEditing) {
        this.isProjectEditingAndEditing = isProjectEditingAndEditing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}