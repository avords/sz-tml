package com.parkdt.tml.domain;

import java.io.Serializable;
import java.util.Date;

public class ProjectModule implements Serializable {
    private Long id;

    private Long designTypeId;

    private String name;

    private Double outputValue;

    private Long cycleId;

    private Date startTime;

    private Date endTime;

    private String description;

    private Long designerId;

    private Long auditorId;

    private Date createTime;

    private Date updateTime;

    private Long stageId;

    private Long stageSubkeyId;

    private Long projectId;

    private Short status;

    private Short summarizeStatus;

    private Short type;

    private Integer suspendCount;

    private Short isPriority;

    private Short isDel;

    private Integer cycleValue;

    private Short cycleUnit;

    private Short auditorConfirm;

    private Short managerConfirm;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDesignTypeId() {
        return designTypeId;
    }

    public void setDesignTypeId(Long designTypeId) {
        this.designTypeId = designTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(Double outputValue) {
        this.outputValue = outputValue;
    }

    public Long getCycleId() {
        return cycleId;
    }

    public void setCycleId(Long cycleId) {
        this.cycleId = cycleId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Long designerId) {
        this.designerId = designerId;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
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

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public Long getStageSubkeyId() {
        return stageSubkeyId;
    }

    public void setStageSubkeyId(Long stageSubkeyId) {
        this.stageSubkeyId = stageSubkeyId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getSummarizeStatus() {
        return summarizeStatus;
    }

    public void setSummarizeStatus(Short summarizeStatus) {
        this.summarizeStatus = summarizeStatus;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Integer getSuspendCount() {
        return suspendCount;
    }

    public void setSuspendCount(Integer suspendCount) {
        this.suspendCount = suspendCount;
    }

    public Short getIsPriority() {
        return isPriority;
    }

    public void setIsPriority(Short isPriority) {
        this.isPriority = isPriority;
    }

    public Short getIsDel() {
        return isDel;
    }

    public void setIsDel(Short isDel) {
        this.isDel = isDel;
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

    public Short getAuditorConfirm() {
        return auditorConfirm;
    }

    public void setAuditorConfirm(Short auditorConfirm) {
        this.auditorConfirm = auditorConfirm;
    }

    public Short getManagerConfirm() {
        return managerConfirm;
    }

    public void setManagerConfirm(Short managerConfirm) {
        this.managerConfirm = managerConfirm;
    }
}