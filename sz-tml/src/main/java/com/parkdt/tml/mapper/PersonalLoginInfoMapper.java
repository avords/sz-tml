package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.PersonalLoginInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PersonalLoginInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PersonalLoginInfo record);

    int insertSelective(PersonalLoginInfo record);

    PersonalLoginInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PersonalLoginInfo record);

    int updateByPrimaryKey(PersonalLoginInfo record);

    PersonalLoginInfo getPersonalLoginInfoByOpenId(String wechat_id);

    List<PersonalLoginInfo> getPersonalLoginInfoByPhone(String phone);

    Integer getCountByParams(Map params);

    List<PersonalLoginInfo> queryByParams(Map params);
}