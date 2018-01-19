package com.parkdt.tml.domain;

import java.io.Serializable;
import java.util.Date;

public class ProjectClaimRecord implements Serializable {
    private Long id;

    private Long projectDeliveryId;

    private Long memberId;

    private Double outputValue;

    private String workPlan;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Short status;

    private Date updateTime;

    private Long updateId;

    private String rejectReason;

    private Short type;

    private Short isView;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectDeliveryId() {
        return projectDeliveryId;
    }

    public void setProjectDeliveryId(Long projectDeliveryId) {
        this.projectDeliveryId = projectDeliveryId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Double getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(Double outputValue) {
        this.outputValue = outputValue;
    }

    public String getWorkPlan() {
        return workPlan;
    }

    public void setWorkPlan(String workPlan) {
        this.workPlan = workPlan == null ? null : workPlan.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason == null ? null : rejectReason.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getIsView() {
        return isView;
    }

    public void setIsView(Short isView) {
        this.isView = isView;
    }
}