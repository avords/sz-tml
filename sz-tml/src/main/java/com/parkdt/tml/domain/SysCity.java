package com.parkdt.tml.domain;

import java.io.Serializable;

public class SysCity implements Serializable {
    private Long id;

    private String name;

    private Integer rank;

    private Integer parentId;

    private Integer vesymy;

    private Integer ishot;

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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getVesymy() {
        return vesymy;
    }

    public void setVesymy(Integer vesymy) {
        this.vesymy = vesymy;
    }

    public Integer getIshot() {
        return ishot;
    }

    public void setIshot(Integer ishot) {
        this.ishot = ishot;
    }
}