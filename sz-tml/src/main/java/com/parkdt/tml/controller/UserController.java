package com.parkdt.tml.controller;

import com.parkdt.tml.domain.PersonalBaseInfo;
import com.parkdt.tml.domain.PersonalLoginInfo;
import com.parkdt.tml.domain.PersonalVerificationCodeRecord;
import com.parkdt.tml.domain.TeamBasicInformation;
import com.parkdt.tml.service.PersonalVerificationCodeRecordService;
import com.parkdt.tml.service.TeamService;
import com.parkdt.tml.service.UserService;
import com.parkdt.tml.utils.EncryptUtil;
import com.parkdt.tml.utils.RandomUtils;
import com.parkdt.tml.utils.SMSUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by guojianhua on 2018/01/09.
 * <p>
 * 个人资料 信息绑定
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private PersonalVerificationCodeRecordService personalVerificationCodeRecordService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping("personal")
    public String toPersonal(Model model, HttpServletRequest req) {

        Long memberId = getMemberId();

        if (0 == memberId) {
            return "redirect:/auth/login";
        }
        PersonalBaseInfo personalBaseInfo = userService.getPersonalBaseInfoByMemberId(memberId);
        if (personalBaseInfo == null) {
            personalBaseInfo = new PersonalBaseInfo();
            personalBaseInfo.setBirthday(new Date());
            personalBaseInfo.setMemberId(memberId);
        }
        model.addAttribute("personalBaseInfo", personalBaseInfo);
        List<TeamBasicInformation> teamBasicInformations = teamService.getAllTeamBasicInfo();
        model.addAttribute("teamBasicInformations", teamBasicInformations);

        return "personal";
    }


    @RequestMapping("savePersonal")
    @ResponseBody
    public boolean savePersonal(Model model, HttpServletRequest req, PersonalBaseInfo personalBaseInfo) {

        Long teamId = personalBaseInfo.getTeamId();

        if (teamId != null) {
            TeamBasicInformation teamBasicInformation = teamService.getByTeamId(teamId);
            if (teamBasicInformation != null) {
                personalBaseInfo.setTeamName(teamBasicInformation.getName());
            }
        }
        int i = userService.updatePersonInfo(personalBaseInfo);

        return i==0?false:true;
    }

    @RequestMapping("register")
    public String register(Model model, HttpServletRequest req, PersonalLoginInfo personalLoginInfo) {
        if (personalLoginInfo == null || StringUtils.isBlank(personalLoginInfo.getPhone())) {
            return "register";
        }
        try {
            //判断验证码是否正确
            String smsCode = req.getParameter("smsCode");
            PersonalVerificationCodeRecord personalVerificationCodeRecord = personalVerificationCodeRecordService.queryValidateCodeByPhoneAndType(personalLoginInfo.getPhone(), (short) 2);
            if (personalVerificationCodeRecord != null && personalVerificationCodeRecord.getCode().equals(smsCode)) {

                //判断手机号是否存在
                List<PersonalLoginInfo> infoExists = userService.getPersonalLoginInfoByPhone(personalLoginInfo.getPhone());

                if (!CollectionUtils.isEmpty(infoExists)) {

                    personalLoginInfo = infoExists.get(0);

                    //号码存在则更新opnid
                    int result = userService.updatePersonalLoginInfo(personalLoginInfo);

                    if (result > 0) {
                        return "redirect:/auth/personal";
                    }
                } else {
                    String password = EncryptUtil.encrypt(personalLoginInfo.getPassword());
                    personalLoginInfo.setPassword(password);
                    personalLoginInfo.setWechatId(personalLoginInfo.getWechatId());
                    personalLoginInfo.setRegistrationTime(new Date());
                    personalLoginInfo.setRoleId(2);
                    if (userService.saveSelective(personalLoginInfo) > 0) {

                        personalLoginInfo = userService.getPersonalLoginInfoByOpenId(personalLoginInfo.getWechatId());
                        if (personalLoginInfo.getId() != 0) {
                            return "redirect:/auth/personal";
                        }
                    }
                }

                return "redirect:/auth/login";
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return "register";
    }

    @RequestMapping("login")
    public String infoBind(Model model, HttpServletRequest req, PersonalLoginInfo personalLoginInfo) {

        String openId = getOpenId();
        PersonalLoginInfo userInfo = userService.getPersonalLoginInfoByOpenId(openId);

        logger.info("login:" + openId);
        if (null != userInfo) {
            return "redirect:/auth/personal";
        } else {
            PersonalLoginInfo personalLoginInfo1 = new PersonalLoginInfo();
            personalLoginInfo1.setWechatId(openId);
            model.addAttribute("personalLoginInfo", personalLoginInfo1);
            return "register";
        }
    }

    @RequestMapping("sendSms")
    @ResponseBody
    public boolean sendSms(Model model, HttpServletRequest req) {
        try {
            String code = RandomUtils.getValidateCode();
            String phone = req.getParameter("phone");
            Short type = Short.valueOf(req.getParameter("type"));
            boolean flag = SMSUtil.sendBindSms(phone, "{\"code\":" + code + "}");
            if (flag) {
                PersonalVerificationCodeRecord personalVerificationCodeRecord = new PersonalVerificationCodeRecord();
                personalVerificationCodeRecord.setPhone(phone);
                personalVerificationCodeRecord.setCode(code);
                personalVerificationCodeRecord.setMemberId(getMemberId());
                personalVerificationCodeRecord.setCreateTime(new Date());
                personalVerificationCodeRecord.setFailureTime(DateUtils.addMinutes(new Date(), 10));//十分钟有效
                personalVerificationCodeRecord.setUseFlag((short) 0);
                personalVerificationCodeRecord.setType(type);
                personalVerificationCodeRecordService.saveValidateCode(personalVerificationCodeRecord);
                return true;
            }
        } catch (Exception e) {
            logger.error("短信发送异常：" + e.getMessage());
        }
        //稍后再试
        return false;
    }
}
