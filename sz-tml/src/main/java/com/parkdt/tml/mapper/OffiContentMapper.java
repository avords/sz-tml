package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.OffiContent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OffiContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OffiContent record);

    int insertSelective(OffiContent record);

    OffiContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OffiContent record);

    int updateByPrimaryKeyWithBLOBs(OffiContent record);

    int updateByPrimaryKey(OffiContent record);
}