package com.parkdt.tml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guojianhua on 2018/01/09.
 *
 * 我参与的 我发布的
 */
@Controller
@RequestMapping(value = "/biz")
public class BizController {

    @RequestMapping("publish")
    public String publish(Model model, HttpServletRequest req) {

        //我发布的
        return "publishList";
    }

    @RequestMapping("take")
    public String take(Model model, HttpServletRequest req) {
        //我参与的
        return "takeList";
    }
}
