package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.OffiContent;

public interface OffiContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OffiContent record);

    int insertSelective(OffiContent record);

    OffiContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OffiContent record);

    int updateByPrimaryKeyWithBLOBs(OffiContent record);

    int updateByPrimaryKey(OffiContent record);
}