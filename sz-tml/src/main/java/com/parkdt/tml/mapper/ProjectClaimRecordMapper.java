package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.ProjectClaimRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectClaimRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectClaimRecord record);

    int insertSelective(ProjectClaimRecord record);

    ProjectClaimRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectClaimRecord record);

    int updateByPrimaryKey(ProjectClaimRecord record);

    Long getCountByParam(Map map);

    List<Map> queryProjectClaimByMemberId(Long memberId);

}