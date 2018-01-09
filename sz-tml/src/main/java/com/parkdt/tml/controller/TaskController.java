package com.parkdt.tml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guojianhua on 2018/01/09.
 *
 * 任务发布 任务报名 任务报名详情页
 */
@Controller
@RequestMapping(value = "/task")
public class TaskController {

    @RequestMapping("publish")
    public String publish(Model model, HttpServletRequest req) {
        return "任务发布";
    }

    @RequestMapping("enter")
    public String enter(Model model, HttpServletRequest req) {
        return "任务报名";
    }

    @RequestMapping("detail")
    public String taskDetail(Model model, HttpServletRequest req) {
        return "任务报名详情页";
    }
}
