package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.SysCity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysCityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysCity record);

    int insertSelective(SysCity record);

    SysCity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysCity record);

    int updateByPrimaryKey(SysCity record);

    List<SysCity> getAllCityByProvinceId(Long provinceId);

    List<SysCity> getAllProvince();
}