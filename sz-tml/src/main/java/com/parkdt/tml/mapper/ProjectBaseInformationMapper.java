package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.ProjectBaseInformation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectBaseInformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectBaseInformation record);

    int insertSelective(ProjectBaseInformation record);

    ProjectBaseInformation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectBaseInformation record);

    int updateByPrimaryKey(ProjectBaseInformation record);
}