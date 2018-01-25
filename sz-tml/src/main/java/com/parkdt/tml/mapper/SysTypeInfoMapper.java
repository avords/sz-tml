package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.SysTypeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysTypeInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysTypeInfo record);

    int insertSelective(SysTypeInfo record);

    SysTypeInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysTypeInfo record);

    int updateByPrimaryKey(SysTypeInfo record);

    List<SysTypeInfo> getByTypeId(Long typeId);
}