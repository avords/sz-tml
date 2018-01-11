package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.PersonalLoginInfo;

public interface PersonalLoginInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PersonalLoginInfo record);

    int insertSelective(PersonalLoginInfo record);

    PersonalLoginInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PersonalLoginInfo record);

    int updateByPrimaryKey(PersonalLoginInfo record);
}