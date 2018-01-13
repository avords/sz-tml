package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.OffiDesign;

public interface OffiDesignMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OffiDesign record);

    int insertSelective(OffiDesign record);

    OffiDesign selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OffiDesign record);

    int updateByPrimaryKeyWithBLOBs(OffiDesign record);

    int updateByPrimaryKey(OffiDesign record);
}