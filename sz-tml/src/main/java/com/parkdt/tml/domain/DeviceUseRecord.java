package com.parkdt.tml.domain;

import java.io.Serializable;

public class DeviceUseRecord implements Serializable {
    private Integer id;

    private Integer deviceid;

    private String username;

    private String useproject;

    private String usetime;

    private String backtime;

    private String usenote;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUseproject() {
        return useproject;
    }

    public void setUseproject(String useproject) {
        this.useproject = useproject == null ? null : useproject.trim();
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime == null ? null : usetime.trim();
    }

    public String getBacktime() {
        return backtime;
    }

    public void setBacktime(String backtime) {
        this.backtime = backtime == null ? null : backtime.trim();
    }

    public String getUsenote() {
        return usenote;
    }

    public void setUsenote(String usenote) {
        this.usenote = usenote == null ? null : usenote.trim();
    }
}