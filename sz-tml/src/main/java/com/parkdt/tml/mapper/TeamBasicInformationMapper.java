package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.TeamBasicInformation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamBasicInformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeamBasicInformation record);

    int insertSelective(TeamBasicInformation record);

    TeamBasicInformation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeamBasicInformation record);

    int updateByPrimaryKey(TeamBasicInformation record);
}