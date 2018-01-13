package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.ProjectInformation;

public interface ProjectInformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectInformation record);

    int insertSelective(ProjectInformation record);

    ProjectInformation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectInformation record);

    int updateByPrimaryKey(ProjectInformation record);
}