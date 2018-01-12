package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.OffiBanner;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OffiBannerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OffiBanner record);

    int insertSelective(OffiBanner record);

    OffiBanner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OffiBanner record);

    int updateByPrimaryKeyWithBLOBs(OffiBanner record);

    int updateByPrimaryKey(OffiBanner record);
}