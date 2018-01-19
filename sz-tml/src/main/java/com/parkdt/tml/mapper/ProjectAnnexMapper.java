package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.ProjectAnnex;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectAnnexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectAnnex record);

    int insertSelective(ProjectAnnex record);

    ProjectAnnex selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectAnnex record);

    int updateByPrimaryKey(ProjectAnnex record);

    List<ProjectAnnex> selectByParams(Map<String, Object> params);
}