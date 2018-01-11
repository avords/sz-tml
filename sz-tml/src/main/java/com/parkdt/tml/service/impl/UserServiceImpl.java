package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.PersonalBaseInfo;
import com.parkdt.tml.domain.PersonalLoginInfo;
import com.parkdt.tml.domain.TeamMember;
import com.parkdt.tml.mapper.PersonalBaseInfoMapper;
import com.parkdt.tml.mapper.PersonalLoginInfoMapper;
import com.parkdt.tml.mapper.TeamBasicInformationMapper;
import com.parkdt.tml.mapper.TeamMemberMapper;
import com.parkdt.tml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/11.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PersonalBaseInfoMapper personalBaseInfoMapper;
    @Autowired
    private PersonalLoginInfoMapper personalLoginInfoMapper;
    @Autowired
    private TeamBasicInformationMapper teamBasicInformationMapper;
    @Autowired
    private TeamMemberMapper teamMemberMapper;

    @Override
    public boolean login(PersonalLoginInfo personalLoginInfo) {
        return false;
    }

    @Override
    public void updatePersonInfo(PersonalLoginInfo personalLoginInfo, PersonalBaseInfo personalBaseInfo, TeamMember teamMember) {

    }
}
