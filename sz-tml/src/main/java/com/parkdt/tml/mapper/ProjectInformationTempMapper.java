package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.ProjectInformationTemp;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectInformationTempMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectInformationTemp record);

    int insertSelective(ProjectInformationTemp record);

    ProjectInformationTemp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectInformationTemp record);

    int updateByPrimaryKey(ProjectInformationTemp record);
}