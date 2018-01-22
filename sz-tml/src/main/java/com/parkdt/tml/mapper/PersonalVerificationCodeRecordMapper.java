package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.PersonalVerificationCodeRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface PersonalVerificationCodeRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PersonalVerificationCodeRecord record);

    int insertSelective(PersonalVerificationCodeRecord record);

    PersonalVerificationCodeRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PersonalVerificationCodeRecord record);

    int updateByPrimaryKey(PersonalVerificationCodeRecord record);

    PersonalVerificationCodeRecord queryValidateCodeByPhone(Map params);
}