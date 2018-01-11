package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.TeamMember;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeamMember record);

    int insertSelective(TeamMember record);

    TeamMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeamMember record);

    int updateByPrimaryKey(TeamMember record);
}