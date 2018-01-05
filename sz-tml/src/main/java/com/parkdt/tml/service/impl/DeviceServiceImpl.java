package com.parkdt.tml.service.impl;

import com.parkdt.tml.consist.Constant;
import com.parkdt.tml.domain.Device;
import com.parkdt.tml.domain.DeviceUseRecord;
import com.parkdt.tml.mapper.DeviceMapper;
import com.parkdt.tml.mapper.DeviceUseRecordMapper;
import com.parkdt.tml.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guojianhua on 2017/12/15.
 */
@Service("deviceService")
@Transactional(value = "txManager1", rollbackFor = Exception.class)
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceUseRecordMapper deviceUseRecordMapper;

    @Override
    public Device findExistDevice(String deviceCode) {

        List<Device> list = deviceMapper.findExist(deviceCode);
        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;

    }

    @Override
    public Device findExistDevice(int deviceId, String deviceCode) {
        List<Device> list = deviceMapper.findExistNotSelf(deviceId, deviceCode);
        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int addDevice(Device device) {
        return deviceMapper.add(device);
    }

    @Override
    public int updateDevice(Device device) {
        return deviceMapper.update(device);
    }

    @Override
    public int deleteDevice(int deviceId) {
        return deviceMapper.delete(deviceId);
    }

    @Override
    public boolean updateDeviceState(int deviceId, int state, DeviceUseRecord record) {
        if (state == Constant.Device_State.IN.getCode()) {
            deviceUseRecordMapper.updateBackTime(record.getId(), deviceId, record.getBackTime(), record.getUseNote());
            deviceMapper.updateState(deviceId, state);
        } else if (state == Constant.Device_State.OUT.getCode()) {
            deviceUseRecordMapper.add(record);
            deviceMapper.updateState(deviceId, state);
        }
        return true;
    }

    @Override
    public Device findDevice(int deviceId) {
        return deviceMapper.findDevice(deviceId);
    }

    @Override
    public List<Device> findDeviceList() {
        return deviceMapper.findDeviceList();
    }

    @Override
    public List<DeviceUseRecord> findDeviceUseRecordByDeviceId(int deviceId) {
        return deviceUseRecordMapper.findDeviceUseRecordByDeviceId(deviceId);
    }

    @Override
    public DeviceUseRecord deviceShouldBackRecord(int deviceId) {

        List<DeviceUseRecord> deviceUseRecords = deviceUseRecordMapper.deviceShouldBackRecord(deviceId);

        if (deviceUseRecords.size() > 0) {
            return deviceUseRecords.get(0);
        }
        return null;
    }

    @Override
    public String checkState(int deviceId) {

        Device device = this.findDevice(deviceId);

        if (null == device) {

            return Constant.Device_State.NOThis.getCnName();

        } else {
            DeviceUseRecord deviceUseRecord = this.deviceShouldBackRecord(deviceId);

            if (null != deviceUseRecord) {
                //可还 不可借 不在库
                deviceMapper.updateState(deviceId, Constant.Device_State.OUT.getCode());
                return Constant.Device_State.OUT.getCnName();
            } else {
                //可借 不可还 在库
                deviceMapper.updateState(deviceId, Constant.Device_State.IN.getCode());
                return Constant.Device_State.IN.getCnName();
            }
        }
    }
}
