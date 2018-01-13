package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.SysAreasExpertise;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysAreasExpertiseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysAreasExpertise record);

    int insertSelective(SysAreasExpertise record);

    SysAreasExpertise selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAreasExpertise record);

    int updateByPrimaryKey(SysAreasExpertise record);
}