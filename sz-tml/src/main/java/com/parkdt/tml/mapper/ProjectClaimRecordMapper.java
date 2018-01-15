package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.ProjectClaimRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectClaimRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectClaimRecord record);

    int insertSelective(ProjectClaimRecord record);

    ProjectClaimRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectClaimRecord record);

    int updateByPrimaryKey(ProjectClaimRecord record);
}