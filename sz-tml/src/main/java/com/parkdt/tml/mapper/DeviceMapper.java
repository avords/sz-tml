package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.Device;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by guojianhua on 2017/12/15.
 */
@Mapper
public interface DeviceMapper {

    @Select("select * from Device where DeviceCode = #{deviceCode} ")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "deviceCode", column = "DeviceCode"),
            @Result(property = "deviceName", column = "DeviceName"),
            @Result(property = "deviceType", column = "DeviceType"),
            @Result(property = "deviceState", column = "DeviceState")})
    List<Device> findExist(@Param("deviceCode") String deviceCode);

    @Select("select * from Device where DeviceCode = #{deviceCode} and ID <> #{deviceId}")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "deviceCode", column = "DeviceCode"),
            @Result(property = "deviceName", column = "DeviceName"),
            @Result(property = "deviceType", column = "DeviceType"),
            @Result(property = "deviceState", column = "DeviceState")})
    List<Device> findExistNotSelf(@Param("deviceId") int deviceId,@Param("deviceCode") String deviceCode);

    @Insert("INSERT INTO Device(DeviceCode,DeviceName,DeviceType) " +
            "VALUES(#{deviceCode},#{deviceName},#{deviceType})")
    int add(Device device);

    @Update("update Device set DeviceCode = #{deviceCode},DeviceName = #{deviceName}," +
            "DeviceType = #{deviceType} where ID = #{id}")
    int update(Device device);

    @Delete("delete Device where ID = #{deviceId}")
    int delete(@Param("deviceId") int deviceId);

    @Update("update Device set DeviceState = #{state} where ID = #{deviceId}")
    int updateState(@Param("deviceId") int deviceId, @Param("state") int state);

    @Select("select * from Device where ID = #{deviceId}")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "deviceCode", column = "DeviceCode"),
            @Result(property = "deviceName", column = "DeviceName"),
            @Result(property = "deviceType", column = "DeviceType"),
            @Result(property = "deviceState", column = "DeviceState")})
    Device findDevice(@Param("deviceId") int deviceId);

    @Select("select * from Device order by DeviceCode")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "deviceCode", column = "DeviceCode"),
            @Result(property = "deviceName", column = "DeviceName"),
            @Result(property = "deviceType", column = "DeviceType"),
            @Result(property = "deviceState", column = "DeviceState")
    })
    List<Device> findDeviceList();
}
