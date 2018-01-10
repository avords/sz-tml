package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.DeviceUseRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceUseRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeviceUseRecord record);

    int insertSelective(DeviceUseRecord record);

    DeviceUseRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeviceUseRecord record);

    int updateByPrimaryKey(DeviceUseRecord record);
}