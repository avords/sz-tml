package com.parkdt.tml.domain;

import java.io.Serializable;
import java.util.Date;

public class ProjectBaseInformation implements Serializable {
    private Long id;

    private String projectNum;

    private Long companyId;

    private Long managerId;

    private Long memberId;

    private String projectName;

    private String details;

    private Short projectStatus;

    private Date createTime;

    private Short status;

    private Long updateId;

    private String updateName;

    private Date finalCertificationTime;

    private Short isAutomaticRelease;

    private Short isTop;

    private String invitePmIds;

    private Short type;

    private Short recommend;

    private Date startTime;

    private Date endTime;

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

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public Short getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Short projectStatus) {
        this.projectStatus = projectStatus;
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

    public Short getIsTop() {
        return isTop;
    }

    public void setIsTop(Short isTop) {
        this.isTop = isTop;
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

    public Short getRecommend() {
        return recommend;
    }

    public void setRecommend(Short recommend) {
        this.recommend = recommend;
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
}