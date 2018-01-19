package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.ProjectModule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectModuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectModule record);

    int insertSelective(ProjectModule record);

    ProjectModule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectModule record);

    int updateByPrimaryKey(ProjectModule record);
}