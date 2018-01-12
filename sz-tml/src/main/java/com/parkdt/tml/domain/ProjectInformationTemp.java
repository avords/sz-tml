package com.parkdt.tml.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProjectInformationTemp implements Serializable {
    private Long id;

    private String projectNum;

    private Long companyId;

    private Long memberId;

    private Long fieldId;

    private Long designTypeId;

    private String constructionUnit;

    private String contactPerson;

    private String phone;

    private Long provinceId;

    private String provinceName;

    private Long cityId;

    private String cityName;

    private Long areaId;

    private String details;

    private String detailedAddress;

    private Double constructionArea;

    private Double planningArea;

    private String projectName;

    private String personnelRequirements;

    private Date planStartTime;

    private Date planEndTime;

    private Integer cycleId;

    private BigDecimal putAmount;

    private Long acquisitionTypeId;

    private Long sourceId;

    private String resultsRequiredIds;

    private String relatedInformation;

    private Date createTime;

    private Short status;

    private String rejectReason;

    private Long updateId;

    private String updateName;

    private Short projectStatus;

    private Date finalCertificationTime;

    private Short isAutomaticRelease;

    private String invitePmIds;

    private Short type;

    private Short isTop;

    private Short isResubmit;

    private Date updateTime;

    private Integer cycleValue;

    private Short cycleUnit;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(String projectNum) {
        this.projectNum = projectNum == null ? null : projectNum.trim();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public Long getDesignTypeId() {
        return designTypeId;
    }

    public void setDesignTypeId(Long designTypeId) {
        this.designTypeId = designTypeId;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit == null ? null : constructionUnit.trim();
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress == null ? null : detailedAddress.trim();
    }

    public Double getConstructionArea() {
        return constructionArea;
    }

    public void setConstructionArea(Double constructionArea) {
        this.constructionArea = constructionArea;
    }

    public Double getPlanningArea() {
        return planningArea;
    }

    public void setPlanningArea(Double planningArea) {
        this.planningArea = planningArea;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getPersonnelRequirements() {
        return personnelRequirements;
    }

    public void setPersonnelRequirements(String personnelRequirements) {
        this.personnelRequirements = personnelRequirements == null ? null : personnelRequirements.trim();
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public Integer getCycleId() {
        return cycleId;
    }

    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    public BigDecimal getPutAmount() {
        return putAmount;
    }

    public void setPutAmount(BigDecimal putAmount) {
        this.putAmount = putAmount;
    }

    public Long getAcquisitionTypeId() {
        return acquisitionTypeId;
    }

    public void setAcquisitionTypeId(Long acquisitionTypeId) {
        this.acquisitionTypeId = acquisitionTypeId;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getResultsRequiredIds() {
        return resultsRequiredIds;
    }

    public void setResultsRequiredIds(String resultsRequiredIds) {
        this.resultsRequiredIds = resultsRequiredIds == null ? null : resultsRequiredIds.trim();
    }

    public String getRelatedInformation() {
        return relatedInformation;
    }

    public void setRelatedInformation(String relatedInformation) {
        this.relatedInformation = relatedInformation == null ? null : relatedInformation.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason == null ? null : rejectReason.trim();
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Short getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Short projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Date getFinalCertificationTime() {
        return finalCertificationTime;
    }

    public void setFinalCertificationTime(Date finalCertificationTime) {
        this.finalCertificationTime = finalCertificationTime;
    }

    public Short getIsAutomaticRelease() {
        return isAutomaticRelease;
    }

    public void setIsAutomaticRelease(Short isAutomaticRelease) {
        this.isAutomaticRelease = isAutomaticRelease;
    }

    public String getInvitePmIds() {
        return invitePmIds;
    }

    public void setInvitePmIds(String invitePmIds) {
        this.invitePmIds = invitePmIds == null ? null : invitePmIds.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getIsTop() {
        return isTop;
    }

    public void setIsTop(Short isTop) {
        this.isTop = isTop;
    }

    public Short getIsResubmit() {
        return isResubmit;
    }

    public void setIsResubmit(Short isResubmit) {
        this.isResubmit = isResubmit;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCycleValue() {
        return cycleValue;
    }

    public void setCycleValue(Integer cycleValue) {
        this.cycleValue = cycleValue;
    }

    public Short getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(Short cycleUnit) {
        this.cycleUnit = cycleUnit;
    }
}