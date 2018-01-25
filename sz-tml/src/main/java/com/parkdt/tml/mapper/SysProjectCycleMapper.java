package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.SysProjectCycle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysProjectCycleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysProjectCycle record);

    int insertSelective(SysProjectCycle record);

    SysProjectCycle selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysProjectCycle record);

    int updateByPrimaryKey(SysProjectCycle record);

    List<SysProjectCycle> getAll();
}