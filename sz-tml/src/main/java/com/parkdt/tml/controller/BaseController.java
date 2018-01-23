package com.parkdt.tml.controller;

import com.parkdt.tml.domain.PersonalLoginInfo;
import com.parkdt.tml.service.UserService;
import com.parkdt.tml.utils.StringKit;
import com.parkdt.tml.weChat.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/1/19.
 */
public class BaseController {

    @Autowired
    private WeChatService weChatService;

    @Autowired
    private UserService userService;

    public Long getMemberId() {

        String openId = getOpenId();

        if (StringKit.isNotEmpty(openId)) {
            PersonalLoginInfo user = userService.getPersonalLoginInfoByOpenId(openId);
            return user == null ? 0L : user.getId();
        }
        //测试
        return 0L;
    }

    public String getOpenId() {

        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String code = req.getParameter("code");

        if (StringKit.isNotEmpty(code)) {

            String openId = weChatService.getOpenId(code);

            return openId;
        }

        return "omd-50nJHn9FqFG2XFHnbQF8bGn8";
    }
}
