package com.parkdt.tml.controller;

import com.parkdt.tml.consist.Constant;
import com.parkdt.tml.domain.PersonalLoginInfo;
import com.parkdt.tml.service.UserService;
import com.parkdt.tml.utils.StringKit;
import com.parkdt.tml.weChat.WeChatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/1/19.
 */
public class BaseController {

    @Autowired
    private WeChatService weChatService;

    @Autowired
    private UserService userService;
    public PersonalLoginInfo getCurrentUser(){
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = req.getSession();
        PersonalLoginInfo personalLoginInfo = (PersonalLoginInfo) session.getAttribute(Constant.SESSION_USER);
        if(personalLoginInfo!=null){
            return personalLoginInfo;
        }
        String openId = getOpenId();

        if (StringKit.isNotEmpty(openId)) {
            PersonalLoginInfo user = userService.getPersonalLoginInfoByOpenId(openId);
            return user;
        }
        return null;
    }
    public Long getMemberId() {
        PersonalLoginInfo personalLoginInfo = getCurrentUser();
        if(personalLoginInfo==null){
            return 0L;
        }
        //测试
        return personalLoginInfo.getId();
    }

    public String getOpenId() {

        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = req.getSession();
        String openId = (String) session.getAttribute(Constant.SESSION_OPEN_ID);
        if(StringUtils.isNotBlank(openId)){
            return openId;
        }
        String code = req.getParameter("code");
        if(StringUtils.isNotBlank(code)){
            openId = weChatService.getOpenId(code);
            session.setAttribute(Constant.SESSION_OPEN_ID,openId);
        }
        return openId;
    }
}
