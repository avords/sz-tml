package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.PersonalBaseInfo;
import com.parkdt.tml.domain.PersonalLoginInfo;
import com.parkdt.tml.mapper.PersonalBaseInfoMapper;
import com.parkdt.tml.mapper.PersonalLoginInfoMapper;
import com.parkdt.tml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/1/11.
 */
@Service("userService")
@Transactional(value = "txManager1", rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private PersonalBaseInfoMapper personalBaseInfoMapper;
    @Autowired
    private PersonalLoginInfoMapper personalLoginInfoMapper;

    @Override
    public boolean login(PersonalLoginInfo personalLoginInfo) {
        return false;
    }

    @Override
    public void updatePersonInfo(PersonalBaseInfo personalBaseInfo) {
        if(personalBaseInfo.getId()==null){
            personalBaseInfoMapper.insertSelective(personalBaseInfo);
        }else {
            personalBaseInfoMapper.updateByPrimaryKeySelective(personalBaseInfo);
        }
    }

    @Override
    public PersonalLoginInfo getPersonalLoginInfoById(Long id) {
        return null;
    }

    @Override
    public PersonalBaseInfo getPersonalBaseInfoByMemberId(Long memberId) {
        return personalBaseInfoMapper.getByMemberId(memberId);
    }
}
