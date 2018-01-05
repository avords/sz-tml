package com.parkdt.tml.domain;

import com.parkdt.tml.utils.DateUtil;

import java.util.Date;

/**
 * Created by guojianhua on 2017/12/15.
 */
public class DeviceUseRecord {

    private int id;

    private int deviceId;

    private String userName;

    private String useProject;

    private Date useTime;

    private Date backTime;

    private String useNote;

    private String useTimeStr;

    private String backTimeStr="";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUseProject() {
        return useProject;
    }

    public void setUseProject(String useProject) {
        this.useProject = useProject;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        if (null != useTime) {
            setUseTimeStr(DateUtil.formatDate(useTime, "yyyy-MM-dd"));
        }
        this.useTime = useTime;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {

        if (null != backTime) {
            setBackTimeStr(DateUtil.formatDate(backTime, "yyyy-MM-dd"));
        }
        this.backTime = backTime;
    }

    public String getUseNote() {
        return useNote;
    }

    public void setUseNote(String useNote) {
        this.useNote = useNote;
    }

    public String getUseTimeStr() {
        return useTimeStr;
    }

    public void setUseTimeStr(String useTimeStr) {
        this.useTimeStr = useTimeStr;
    }

    public String getBackTimeStr() {
        return backTimeStr;
    }

    public void setBackTimeStr(String backTimeStr) {
        this.backTimeStr = backTimeStr;
    }
}
