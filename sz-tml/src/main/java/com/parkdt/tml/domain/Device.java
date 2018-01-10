package com.parkdt.tml.domain;

import java.io.Serializable;

public class Device implements Serializable {
    private Integer id;

    private String devicecode;

    private String devicename;

    private String devicetype;

    private Integer devicestate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevicecode() {
        return devicecode;
    }

    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode == null ? null : devicecode.trim();
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename == null ? null : devicename.trim();
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype == null ? null : devicetype.trim();
    }

    public Integer getDevicestate() {
        return devicestate;
    }

    public void setDevicestate(Integer devicestate) {
        this.devicestate = devicestate;
    }
}