package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.Device;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}