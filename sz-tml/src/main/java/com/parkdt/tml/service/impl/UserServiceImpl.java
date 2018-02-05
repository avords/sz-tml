package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.PersonalBaseInfo;
import com.parkdt.tml.domain.PersonalLoginInfo;
import com.parkdt.tml.mapper.PersonalBaseInfoMapper;
import com.parkdt.tml.mapper.PersonalLoginInfoMapper;
import com.parkdt.tml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public int updatePersonInfo(PersonalBaseInfo personalBaseInfo) {
        if (personalBaseInfo.getId() == null) {

            PersonalBaseInfo baseInfo = personalBaseInfoMapper.getByMemberId(personalBaseInfo.getMemberId());
            if (baseInfo == null) {
                return personalBaseInfoMapper.insertSelective(personalBaseInfo);
            } else {
                return personalBaseInfoMapper.updateByMemberId(personalBaseInfo);
            }
        } else {
            return personalBaseInfoMapper.updateByPrimaryKeySelective(personalBaseInfo);
        }
    }

    @Override
    public PersonalLoginInfo getPersonalLoginInfoById(Long id) {
        return personalLoginInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public PersonalBaseInfo getPersonalBaseInfoByMemberId(Long memberId) {
        return personalBaseInfoMapper.getByMemberId(memberId);
    }

    @Override
    public PersonalLoginInfo getPersonalLoginInfoByOpenId(String wechatId) {
        return personalLoginInfoMapper.getPersonalLoginInfoByOpenId(wechatId);
    }

    @Override
    public List<PersonalLoginInfo> getPersonalLoginInfoByPhone(String phone) {
        return personalLoginInfoMapper.getPersonalLoginInfoByPhone(phone);
    }

    @Override
    public int updatePersonalLoginInfo(PersonalLoginInfo personalLoginInfo) {
        return personalLoginInfoMapper.updateByPrimaryKeySelective(personalLoginInfo);
    }

    @Override
    public int saveSelective(PersonalLoginInfo personalLoginInfo) {
        int result = personalLoginInfoMapper.insertSelective(personalLoginInfo);
        return result;
    }

    @Override
    public int updateOpenIdByPhone(String phone, String openId) {

        PersonalLoginInfo personalLoginInfo = new PersonalLoginInfo();
        personalLoginInfo.setPhone(phone);
        personalLoginInfo.setWechatId(openId);

        return personalLoginInfoMapper.updateOpenIdByPhone(personalLoginInfo);
    }
}
