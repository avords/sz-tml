package com.parkdt.tml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guojianhua on 2018/01/09.
 *
 * 个人资料 信息绑定
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping("personal")
    public String personal(Model model, HttpServletRequest req) {
        return "个人资料";
    }

    @RequestMapping("info")
    public String infoBind(Model model, HttpServletRequest req) {
        return "信息绑定";
    }
}
