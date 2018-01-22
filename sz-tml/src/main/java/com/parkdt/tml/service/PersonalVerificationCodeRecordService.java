package com.parkdt.tml.service;

import com.parkdt.tml.domain.PersonalVerificationCodeRecord;

/**
 * Created by Administrator on 2018/1/22.
 */
public interface PersonalVerificationCodeRecordService {

    PersonalVerificationCodeRecord queryValidateCodeByPhoneAndType(String phone,Short type);

    PersonalVerificationCodeRecord saveValidateCode(PersonalVerificationCodeRecord personalVerificationCodeRecord);

    int updateValidateCodeStatus(PersonalVerificationCodeRecord personalVerificationCodeRecord);

}
