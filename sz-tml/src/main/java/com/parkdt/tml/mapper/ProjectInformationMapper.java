package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.ProjectInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface ProjectInformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectInformation record);

    int insertSelective(ProjectInformation record);

    ProjectInformation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectInformation record);

    int updateByPrimaryKey(ProjectInformation record);

    List<ProjectInformation> getAllProject();

    List<ProjectInformation> getProjectByParam(Map<String, Object> params);
    
    List<Map> queryBySql(Map<String, Object> params);

    List<Map> queryProjectByMemberId(Long memberId);

}