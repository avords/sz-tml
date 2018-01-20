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
    void updatePersonInfo(PersonalBaseInfo personalBaseInfo);

    /**
     * 通过用户id得到个人登录信息
     * @param id
     * @return
     */
    PersonalLoginInfo getPersonalLoginInfoById(Long id);
    /**
     * 通过用户id得到个人基本信息
     * @param id
     * @return
     */
    PersonalBaseInfo getPersonalBaseInfoByMemberId(Long memberId);

    /**
     * 通过用户openid得到个人登录信息
     * @param openid
     * @return
     */
    PersonalLoginInfo getPersonalLoginInfoByOpenId(String wechat_id);
}
