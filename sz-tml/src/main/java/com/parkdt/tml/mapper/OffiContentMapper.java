package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.OffiContent;
import com.parkdt.tml.domain.TeamBasicInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OffiContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OffiContent record);

    int insertSelective(OffiContent record);

    OffiContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OffiContent record);

    int updateByPrimaryKeyWithBLOBs(OffiContent record);

    int updateByPrimaryKey(OffiContent record);

    List<OffiContent> getContentByPartId(Long part_id);
}