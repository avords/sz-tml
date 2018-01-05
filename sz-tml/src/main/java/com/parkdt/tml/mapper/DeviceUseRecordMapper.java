package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.DeviceUseRecord;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by guojianhua on 2017/12/15.
 */
@Mapper
public interface DeviceUseRecordMapper {

    @Select("select * from DeviceUseRecord where BackTime is null and deviceId = #{deviceId} order by ID Desc")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "deviceId", column = "DeviceID"),
            @Result(property = "userName", column = "UserName"),
            @Result(property = "useProject", column = "UseProject"),
            @Result(property = "useTime", column = "UseTime"),
            @Result(property = "backTime", column = "BackTime"),
            @Result(property = "useNote", column = "UseNote")
    })
    List<DeviceUseRecord> deviceShouldBackRecord(@Param("deviceId") int deviceId);

    @Insert("INSERT INTO DeviceUseRecord(DeviceID,UserName,UseProject,UseTime,UseNote) " +
            "VALUES (#{deviceId},#{userName},#{useProject},#{useTime},#{useNote})")
    int add(DeviceUseRecord record);

    @Update("update DeviceUseRecord set BackTime = #{backTime},useNote = #{useNote} where DeviceID = #{deviceId} and ID = #{id}")
    int updateBackTime(@Param("id") int id, @Param("deviceId") int deviceId, @Param("backTime") Date backTime, @Param("useNote") String useNote);

    @Select("select * from DeviceUseRecord where DeviceID = #{deviceId}  order by ID Desc ")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "deviceId", column = "DeviceID"),
            @Result(property = "userName", column = "UserName"),
            @Result(property = "useProject", column = "UseProject"),
            @Result(property = "useTime", column = "UseTime"),
            @Result(property = "backTime", column = "BackTime"),
            @Result(property = "useNote", column = "UseNote")
    })
    List<DeviceUseRecord> findDeviceUseRecordByDeviceId(@Param("deviceId") int deviceId);

}
