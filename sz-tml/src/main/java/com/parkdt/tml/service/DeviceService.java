package com.parkdt.tml.service;

import com.parkdt.tml.domain.Device;

/**
 * Created by guojianhua on 2017/12/15.
 */
public interface DeviceService {

    int deleteByPrimaryKey(Integer id);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);


}
