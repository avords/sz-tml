package com.parkdt.tml.service;

import com.parkdt.tml.domain.PersonalBaseInfo;
import com.parkdt.tml.domain.PersonalLoginInfo;
import com.parkdt.tml.domain.TeamMember;

import java.util.List;

/**
 * Created by Administrator on 2018/1/11.
 */
public interface UserService {

    /**
     * 更新个人信息
     * @param personalLoginInfo
     * @param personalBaseInfo
     * @param teamMember
     */
    int updatePersonInfo(PersonalBaseInfo personalBaseInfo);

    /**
     * 通过用户id得到个人登录信息
     * @param id
     * @return
     */
    PersonalLoginInfo getPersonalLoginInfoById(Long id);
    /**
     * 通过用户id得到个人基本信息
     * @param memberId
     * @return
     */
    PersonalBaseInfo getPersonalBaseInfoByMemberId(Long memberId);

    /**
     * 通过用户openid得到个人登录信息
     * @param wechat_id
     * @return
     */
    PersonalLoginInfo getPersonalLoginInfoByOpenId(String wechat_id);

    List<PersonalLoginInfo> getPersonalLoginInfoByPhone(String phone);

    int updatePersonalLoginInfo(PersonalLoginInfo personalLoginInfo);

    int saveSelective(PersonalLoginInfo personalLoginInfo);

    int updateOpenIdByPhone(String phone, String openId);
}
