package com.parkdt.tml.controller;

import com.parkdt.tml.service.ProjectService;
import com.parkdt.tml.weChat.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by guojianhua on 2018/01/09.
 * <p>
 * 我参与的 我发布的
 */
@Controller
@RequestMapping(value = "/biz")
public class BizController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("publish")
    public String publish(Model model, HttpServletRequest req) {

        Long memberId = getMemberId();

        //我发布的
        List<Map> projectPublishs = projectService.queryProjectByMemberId(75L);
        model.addAttribute("projectPublishs", projectPublishs);
        return "publishList";
    }

    @RequestMapping("take")
    public String take(Model model, HttpServletRequest req) {

        Long memberId = getMemberId();

        //我参与的
        List<Map> projectClaims = projectService.queryProjectClaimByMemberId(80L);
        model.addAttribute("projectClaims", projectClaims);
        return "takeList";
    }
}
