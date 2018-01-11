package com.parkdt.tml.service;

import com.parkdt.tml.domain.PersonalBaseInfo;
import com.parkdt.tml.domain.PersonalLoginInfo;
import com.parkdt.tml.domain.TeamMember;

/**
 * Created by Administrator on 2018/1/11.
 */
public interface UserService {
    /**
     * 登录
     * @param personalLoginInfo
     * @return
     */
    boolean login(PersonalLoginInfo personalLoginInfo);

    /**
     * 更新个人信息
     * @param personalLoginInfo
     * @param personalBaseInfo
     * @param teamMember
     */
    void updatePersonInfo(PersonalLoginInfo personalLoginInfo, PersonalBaseInfo personalBaseInfo, TeamMember teamMember);
}
