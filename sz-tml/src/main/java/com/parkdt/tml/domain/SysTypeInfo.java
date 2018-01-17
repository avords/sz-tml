package com.parkdt.tml.domain;

import java.io.Serializable;
import java.util.Date;

public class SysTypeInfo implements Serializable {
    private Long id;

    private String typeName;

    private Long typeId;

    private Short isEnabled;

    private Integer sorting;

    private Short isDel;

    private Date createTime;

    private Date updateTime;

    private Long updateId;

    private String updateName;

    private Short isChooseTeam;

    private String color;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Short getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Short isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }

    public Short getIsDel() {
        return isDel;
    }

    public void setIsDel(Short isDel) {
        this.isDel = isDel;
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

    public Short getIsChooseTeam() {
        return isChooseTeam;
    }

    public void setIsChooseTeam(Short isChooseTeam) {
        this.isChooseTeam = isChooseTeam;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }
}