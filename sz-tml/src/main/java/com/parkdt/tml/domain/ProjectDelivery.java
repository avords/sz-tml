package com.parkdt.tml.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProjectDelivery implements Serializable {
    private Long id;

    private Long projectId;

    private Short type;

    private Date createTime;

    private Date updateTime;

    private Short status;

    private Integer pv;

    private Integer claimeNum;

    private Date endTime;

    private Short isDel;

    private Short jobType;

    private Short isDelivery;

    private String image;

    private Long objectId;

    private Short isShow;

    private Short isView;

    private String projectName;

    private BigDecimal outputValue;

    private Short projectStatus;

    private Date planStartTime;

    private Date planEndTime;

    private Date actualStartTime;

    private Date actualEndTime;

    private String moduleIds;

    private Long winningBid;

    private Short isRedo;

    private Long cycleId;

    private String description;

    private Integer cycleValue;

    private Short cycleUnit;
    
    private ProjectInformation projectInformation;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getClaimeNum() {
        return claimeNum;
    }

    public void setClaimeNum(Integer claimeNum) {
        this.claimeNum = claimeNum;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Short getIsDel() {
        return isDel;
    }

    public void setIsDel(Short isDel) {
        this.isDel = isDel;
    }

    public Short getJobType() {
        return jobType;
    }

    public void setJobType(Short jobType) {
        this.jobType = jobType;
    }

    public Short getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(Short isDelivery) {
        this.isDelivery = isDelivery;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Short getIsShow() {
        return isShow;
    }

    public void setIsShow(Short isShow) {
        this.isShow = isShow;
    }

    public Short getIsView() {
        return isView;
    }

    public void setIsView(Short isView) {
        this.isView = isView;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public BigDecimal getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(BigDecimal outputValue) {
        this.outputValue = outputValue;
    }

    public Short getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Short projectStatus) {
        this.projectStatus = projectStatus;
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

    public Date getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public Date getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public String getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(String moduleIds) {
        this.moduleIds = moduleIds == null ? null : moduleIds.trim();
    }

    public Long getWinningBid() {
        return winningBid;
    }

    public void setWinningBid(Long winningBid) {
        this.winningBid = winningBid;
    }

    public Short getIsRedo() {
        return isRedo;
    }

    public void setIsRedo(Short isRedo) {
        this.isRedo = isRedo;
    }

    public Long getCycleId() {
        return cycleId;
    }

    public void setCycleId(Long cycleId) {
        this.cycleId = cycleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public ProjectInformation getProjectInformation() {
        return projectInformation;
    }

    public void setProjectInformation(ProjectInformation projectInformation) {
        this.projectInformation = projectInformation;
    }
}