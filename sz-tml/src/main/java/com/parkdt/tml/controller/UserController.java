package com.parkdt.tml.controller;

import com.parkdt.tml.domain.PersonalBaseInfo;
import com.parkdt.tml.domain.TeamBasicInformation;
import com.parkdt.tml.service.TeamService;
import com.parkdt.tml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by guojianhua on 2018/01/09.
 *
 * 个人资料 信息绑定
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TeamService teamService;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
    
    @RequestMapping("personal")
    public String personal(Model model, HttpServletRequest req) {
        PersonalBaseInfo personalBaseInfo = userService.getPersonalBaseInfoByMemberId(76L);
        model.addAttribute("personalBaseInfo",personalBaseInfo);
        List<TeamBasicInformation> teamBasicInformations = teamService.getAllTeamBasicInfo();
        model.addAttribute("teamBasicInformations",teamBasicInformations);
        return "personal";
    }
    @RequestMapping("savePersonal")
    public String savePersonal(PersonalBaseInfo personalBaseInfo) {
        Long teamId = personalBaseInfo.getTeamId();
        if(teamId!=null) {
            TeamBasicInformation teamBasicInformation = teamService.getByTeamId(teamId);
            if (teamBasicInformation != null) {
                personalBaseInfo.setTeamName(teamBasicInformation.getName());
            }
        }
        userService.updatePersonInfo(personalBaseInfo);
        return "redirect:/user/personal";
    }
    @RequestMapping("info")
    public String infoBind(Model model, HttpServletRequest req) {
        return "infoBind";
    }
}
