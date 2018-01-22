package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.ProjectBaseInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectBaseInformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectBaseInformation record);

    int insertSelective(ProjectBaseInformation record);

    ProjectBaseInformation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectBaseInformation record);

    int updateByPrimaryKey(ProjectBaseInformation record);

    List<Map> queryProjectByMemberId(Long memberId);
}