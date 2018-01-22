package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.PersonalVerificationCodeRecord;
import com.parkdt.tml.mapper.PersonalVerificationCodeRecordMapper;
import com.parkdt.tml.service.PersonalVerificationCodeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/22.
 */
@Service("personalVerificationCodeRecordService")
public class PersonalVerificationCodeRecordServiceImpl implements PersonalVerificationCodeRecordService {
    @Autowired
    private PersonalVerificationCodeRecordMapper personalVerificationCodeRecordMapper;
    @Override
    public PersonalVerificationCodeRecord queryValidateCodeByPhoneAndType(String phone,Short type) {
        Map params = new HashMap();
        params.put("phone",phone);
        params.put("type",type);
        return personalVerificationCodeRecordMapper.queryValidateCodeByPhone(params);
    }

    @Override
    public PersonalVerificationCodeRecord saveValidateCode(PersonalVerificationCodeRecord personalVerificationCodeRecord) {
        personalVerificationCodeRecordMapper.insert(personalVerificationCodeRecord);
        return personalVerificationCodeRecord;
    }

    @Override
    public int updateValidateCodeStatus(PersonalVerificationCodeRecord personalVerificationCodeRecord) {
        return personalVerificationCodeRecordMapper.updateByPrimaryKeySelective(personalVerificationCodeRecord);
    }
}
