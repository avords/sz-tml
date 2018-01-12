package com.parkdt.tml.domain;

import java.io.Serializable;
import java.util.Date;

public class OffiBanner implements Serializable {
    private Long id;

    private String name;

    private Long partId;

    private Short type;

    private Integer sort;

    private Short isEnabled;

    private Short isDel;

    private String url;

    private String videoUrl;

    private String actionUrl;

    private Long createId;

    private String createName;

    private Date createTime;

    private Long updateId;

    private String updateName;

    private Date updateTime;

    private Long updateTimeTamp;

    private Long theChain;

    private String title;

    private String smallTitle;

    private Short linkType;

    private Long linkId;

    private String content;

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

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Short getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Short isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Short getIsDel() {
        return isDel;
    }

    public void setIsDel(Short isDel) {
        this.isDel = isDel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl == null ? null : actionUrl.trim();
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateTimeTamp() {
        return updateTimeTamp;
    }

    public void setUpdateTimeTamp(Long updateTimeTamp) {
        this.updateTimeTamp = updateTimeTamp;
    }

    public Long getTheChain() {
        return theChain;
    }

    public void setTheChain(Long theChain) {
        this.theChain = theChain;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSmallTitle() {
        return smallTitle;
    }

    public void setSmallTitle(String smallTitle) {
        this.smallTitle = smallTitle == null ? null : smallTitle.trim();
    }

    public Short getLinkType() {
        return linkType;
    }

    public void setLinkType(Short linkType) {
        this.linkType = linkType;
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}