package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.PersonalBaseInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonalBaseInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PersonalBaseInfo record);

    int insertSelective(PersonalBaseInfo record);

    PersonalBaseInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PersonalBaseInfo record);

    int updateByPrimaryKey(PersonalBaseInfo record);
    
    PersonalBaseInfo getByMemberId(Long memberId);

    PersonalBaseInfo getByOpenId(Long memberId);

    int updateByMemberId(PersonalBaseInfo record);

}