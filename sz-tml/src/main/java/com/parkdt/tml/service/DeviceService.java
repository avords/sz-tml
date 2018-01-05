package com.parkdt.tml.service;

import com.parkdt.tml.domain.Device;
import com.parkdt.tml.domain.DeviceUseRecord;

import java.util.List;

/**
 * Created by guojianhua on 2017/12/15.
 */
public interface DeviceService {

    Device findExistDevice(String deviceCode);

    Device findExistDevice(int deviceId, String deviceCode);

    int addDevice(Device device);

    int updateDevice(Device device);

    int deleteDevice(int deviceId);

    boolean updateDeviceState(int deviceId, int state, DeviceUseRecord record);

    Device findDevice(int deviceId);

    List<Device> findDeviceList();

    List<DeviceUseRecord> findDeviceUseRecordByDeviceId(int deviceId);

    DeviceUseRecord deviceShouldBackRecord(int deviceId);

    String checkState(int deviceId);


}
