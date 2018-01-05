package com.parkdt.tml.domain;

import com.parkdt.tml.consist.Constant;

/**
 * Created by guojianhua on 2017/12/15.
 */
public class Device {

    private int id;

    private String deviceCode;

    private String deviceName;

    private String deviceType;

    private int deviceState;

    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public int getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(int deviceState) {

        if (deviceState == Constant.Device_State.NoIni.getCode()) {
            setState(Constant.Device_State.NoIni.getCnName());
        } else if (deviceState == Constant.Device_State.IN.getCode()) {
            setState(Constant.Device_State.IN.getCnName());
        } else if (deviceState == Constant.Device_State.OUT.getCode()) {
            setState(Constant.Device_State.OUT.getCnName());
        }

        this.deviceState = deviceState;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
