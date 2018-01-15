package com.parkdt.tml.controller;

import com.parkdt.tml.domain.ProjectInformation;
import com.parkdt.tml.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guojianhua on 2018/01/09.
 *
 * 任务发布 任务报名 任务报名详情页
 */
@Controller
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    private ProjectService projectService;
    @RequestMapping("publish")
    public String publish(Model model, HttpServletRequest req) {
        Map<String, Object> params = new HashMap<String, Object>();
        List<ProjectInformation> projectInformations = projectService.getProjectByParam(params);
        model.addAttribute("projectInformations",projectInformations);
        return "taskPublishList";
    }

    @RequestMapping("enter")
    public String enter(Model model, HttpServletRequest req) {
        return "taskEnter";
    }

    @RequestMapping("detail")
    public String taskDetail(Model model, HttpServletRequest req) {
        return "taskEnterDetail";
    }
}
