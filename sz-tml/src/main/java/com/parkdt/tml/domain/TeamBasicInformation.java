package com.parkdt.tml.domain;

import java.io.Serializable;
import java.util.Date;

public class TeamBasicInformation implements Serializable {
    private Long id;

    private String name;

    private Long industry;

    private String address;

    private String detailedAddress;

    private String representativePerson;

    private String contactNumber;

    private String certificationIntroduction;

    private Long founder;

    private Long certifier;

    private Short status;

    private Date firstCertificationTime;

    private Date finalCertificationTime;

    private String headPortrait;

    private String cover;

    private String detailsImg;

    private String showIntroduction;

    private Date createTime;

    private Long createTimeTemp;

    private Date updateTime;

    private Short recommend;

    private Long provinceId;

    private String provinceName;

    private Long cityId;

    private String cityName;

    private Long areaId;

    private String areaName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getIndustry() {
        return industry;
    }

    public void setIndustry(Long industry) {
        this.industry = industry;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress == null ? null : detailedAddress.trim();
    }

    public String getRepresentativePerson() {
        return representativePerson;
    }

    public void setRepresentativePerson(String representativePerson) {
        this.representativePerson = representativePerson == null ? null : representativePerson.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public String getCertificationIntroduction() {
        return certificationIntroduction;
    }

    public void setCertificationIntroduction(String certificationIntroduction) {
        this.certificationIntroduction = certificationIntroduction == null ? null : certificationIntroduction.trim();
    }

    public Long getFounder() {
        return founder;
    }

    public void setFounder(Long founder) {
        this.founder = founder;
    }

    public Long getCertifier() {
        return certifier;
    }

    public void setCertifier(Long certifier) {
        this.certifier = certifier;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getFirstCertificationTime() {
        return firstCertificationTime;
    }

    public void setFirstCertificationTime(Date firstCertificationTime) {
        this.firstCertificationTime = firstCertificationTime;
    }

    public Date getFinalCertificationTime() {
        return finalCertificationTime;
    }

    public void setFinalCertificationTime(Date finalCertificationTime) {
        this.finalCertificationTime = finalCertificationTime;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait == null ? null : headPortrait.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getDetailsImg() {
        return detailsImg;
    }

    public void setDetailsImg(String detailsImg) {
        this.detailsImg = detailsImg == null ? null : detailsImg.trim();
    }

    public String getShowIntroduction() {
        return showIntroduction;
    }

    public void setShowIntroduction(String showIntroduction) {
        this.showIntroduction = showIntroduction == null ? null : showIntroduction.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateTimeTemp() {
        return createTimeTemp;
    }

    public void setCreateTimeTemp(Long createTimeTemp) {
        this.createTimeTemp = createTimeTemp;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getRecommend() {
        return recommend;
    }

    public void setRecommend(Short recommend) {
        this.recommend = recommend;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }
}