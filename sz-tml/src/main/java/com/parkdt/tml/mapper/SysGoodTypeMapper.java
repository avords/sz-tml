package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.SysGoodType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysGoodTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysGoodType record);

    int insertSelective(SysGoodType record);

    SysGoodType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysGoodType record);

    int updateByPrimaryKey(SysGoodType record);
}