package com.parkdt.tml.weChat.message.fromMessage.event;

import java.util.Map;

public class LocationEvent extends Event {

    /**
     * 地理位置纬度
     */
    private String Latitude;

    /**
     * 地理位置经度
     */
    private String Longitude;

    /**
     * 地理位置精度
     */
    private String Precision;


    public LocationEvent(Map<String, String> param) {
        super(param);
        Latitude = param.get("Latitude");
        Longitude = param.get("Longitude");
        Precision = param.get("Precision");
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }

}
