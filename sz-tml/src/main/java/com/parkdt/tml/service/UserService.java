package com.parkdt.tml.service;

import com.parkdt.tml.domain.PersonalBaseInfo;
import com.parkdt.tml.domain.PersonalLoginInfo;
import com.parkdt.tml.domain.TeamMember;

/**
 * Created by Administrator on 2018/1/11.
 */
public interface UserService {
    boolean login(PersonalLoginInfo personalLoginInfo);
    void updatePersonInfo(PersonalLoginInfo personalLoginInfo, PersonalBaseInfo personalBaseInfo, TeamMember teamMember);
}
