package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.SysTypeInfo;

public interface SysTypeInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysTypeInfo record);

    int insertSelective(SysTypeInfo record);

    SysTypeInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysTypeInfo record);

    int updateByPrimaryKey(SysTypeInfo record);
}