package com.parkdt.tml.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProjectInformation implements Serializable {
    private Long id;

    private Long fieldId;

    private Long designTypeId;

    private String constructionUnit;

    private String contactPerson;

    private Integer claimId;

    private String phone;

    private Long projectConstructionSite;

    private Long provinceId;

    private Long cityId;

    private String provinceName;

    private String cityName;

    private Long area;

    private String detailedAddress;

    private Double constructionArea;

    private Double planningArea;

    private Short projectStatus;

    private String personnelRequirements;

    private Date planStartTime;

    private Date planEndTime;

    private Integer cycleId;

    private BigDecimal putAmount;

    private Long acquisitionTypeId;

    private Long sourceId;

    private String resultsRequiredIds;

    private String relatedInformation;

    private Long projectBaseId;

    private Integer suspendCount;

    private Integer cycleValue;

    private Short cycleUnit;

    private String introduction;
    
    private ProjectBaseInformation projectBaseInformation;
    
    private List<ProjectAnnex> projectAnnexes;
    
    private SysTypeInfo sysTypeInfo;
    
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getClaimId() {
        return claimId;
    }

    public void setClaimId(Integer claimId) {
        this.claimId = claimId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getProjectConstructionSite() {
        return projectConstructionSite;
    }

    public void setProjectConstructionSite(Long projectConstructionSite) {
        this.projectConstructionSite = projectConstructionSite;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
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

    public Short getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Short projectStatus) {
        this.projectStatus = projectStatus;
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

    public Long getProjectBaseId() {
        return projectBaseId;
    }

    public void setProjectBaseId(Long projectBaseId) {
        this.projectBaseId = projectBaseId;
    }

    public Integer getSuspendCount() {
        return suspendCount;
    }

    public void setSuspendCount(Integer suspendCount) {
        this.suspendCount = suspendCount;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public ProjectBaseInformation getProjectBaseInformation() {
        return projectBaseInformation;
    }

    public void setProjectBaseInformation(ProjectBaseInformation projectBaseInformation) {
        this.projectBaseInformation = projectBaseInformation;
    }

    public SysTypeInfo getSysTypeInfo() {
        return sysTypeInfo;
    }

    public void setSysTypeInfo(SysTypeInfo sysTypeInfo) {
        this.sysTypeInfo = sysTypeInfo;
    }

    public List<ProjectAnnex> getProjectAnnexes() {
        return projectAnnexes;
    }

    public void setProjectAnnexes(List<ProjectAnnex> projectAnnexes) {
        this.projectAnnexes = projectAnnexes;
    }
}