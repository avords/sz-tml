package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.PersonalBaseInfo;

public interface PersonalBaseInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PersonalBaseInfo record);

    int insertSelective(PersonalBaseInfo record);

    PersonalBaseInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PersonalBaseInfo record);

    int updateByPrimaryKey(PersonalBaseInfo record);
}