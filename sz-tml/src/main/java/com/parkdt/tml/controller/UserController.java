package com.parkdt.tml.controller;

import com.parkdt.tml.consist.Constant;
import com.parkdt.tml.domain.*;
import com.parkdt.tml.service.PersonalVerificationCodeRecordService;
import com.parkdt.tml.service.TeamService;
import com.parkdt.tml.service.UserService;
import com.parkdt.tml.utils.EncryptUtil;
import com.parkdt.tml.utils.RandomUtils;
import com.parkdt.tml.utils.SMSUtil;
import com.parkdt.tml.utils.StringKit;
import com.parkdt.tml.weChat.WeChatService;
import com.parkdt.tml.weChat.result.WxMpUser;
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
import org.springframework.web.bind.annotation.RequestMethod;
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
    private WeChatService weChatService;
    @Autowired
    private PersonalVerificationCodeRecordService personalVerificationCodeRecordService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping("login")
    public String login(Model model, HttpServletRequest req, PersonalLoginInfo personalLoginInfo) {

        String openId = getOpenId();
        PersonalLoginInfo userInfo = userService.getPersonalLoginInfoByOpenId(openId);

        logger.info("login:" + openId);
        if (null != userInfo) {
            return "redirect:/user/personal";
        } else {
            PersonalLoginInfo personalLoginInfo1 = new PersonalLoginInfo();
            personalLoginInfo1.setWechatId(openId);
            model.addAttribute("personalLoginInfo", personalLoginInfo1);

            return "login";
        }
    }

    @RequestMapping("logining")
    @ResponseBody
    public Result logining(Model model, HttpServletRequest req, PersonalLoginInfo personalLoginInfo) {
        Result result = new Result();

        if (personalLoginInfo == null || StringUtils.isBlank(personalLoginInfo.getWechatId())) {
            result.setStatus("error");
            result.setValue("openid不能为空");
            return result;
        }

        if (personalLoginInfo == null || StringUtils.isBlank(personalLoginInfo.getPhone())) {
            result.setStatus("error").setValue("手机号不能为空");
            return result;
        }

        String smsCode = req.getParameter("smsCode");

        if (smsCode == null || StringUtils.isBlank(smsCode)) {
            result.setStatus("error").setValue("验证码不能为空");
            return result;
        }
        List<PersonalLoginInfo> infoExists = userService.getPersonalLoginInfoByPhone(personalLoginInfo.getPhone());

        if (!CollectionUtils.isEmpty(infoExists)) {
            String openId = personalLoginInfo.getWechatId();
            String phone = personalLoginInfo.getPhone();

            PersonalVerificationCodeRecord personalVerificationCodeRecord = personalVerificationCodeRecordService.queryValidateCodeByPhoneAndType(personalLoginInfo.getPhone(), (short) 2);
            if (personalVerificationCodeRecord != null && personalVerificationCodeRecord.getCode().equals(smsCode)) {

                int count = userService.updateOpenIdByPhone(phone, openId);

                if (count > 0) {
                    result.setStatus("success").setValue("登录成功");
                    return result;
                } else {
                    result.setStatus("error").setValue("更新openid失败");
                    return result;
                }
            } else {
                result.setStatus("error").setValue("验证码不对");
                return result;
            }
        } else {
            result.setStatus("error").setValue("没有此用户信息，请先注册");
            return result;
        }
    }

    @RequestMapping("register")
    public String register(Model model, HttpServletRequest req, PersonalLoginInfo personalLoginInfo) {

        String openId = getOpenId();
        PersonalLoginInfo userInfo = userService.getPersonalLoginInfoByOpenId(openId);

        logger.info("login:" + openId);
        if (null != userInfo) {
            return "redirect:/user/personal";
        } else {
            PersonalLoginInfo personalLoginInfo1 = new PersonalLoginInfo();
            personalLoginInfo1.setWechatId(openId);
            model.addAttribute("personalLoginInfo", personalLoginInfo1);

            return "register";
        }
    }

    @RequestMapping("registering")
    @ResponseBody
    public Result registering(Model model, HttpServletRequest req, PersonalLoginInfo personalLoginInfo) {

        Result result = new Result();
        if (personalLoginInfo == null || StringUtils.isBlank(personalLoginInfo.getWechatId())) {
            result.setStatus("error");
            result.setValue("openid不能为空");
            return result;
        }
        if (personalLoginInfo == null || StringUtils.isBlank(personalLoginInfo.getPhone())) {
            result.setStatus("error").setValue("手机号不能为空");
            return result;
        }
        try {

            String smsCode = req.getParameter("smsCode");

            if (smsCode == null || StringUtils.isBlank(smsCode)) {
                result.setStatus("error").setValue("验证码不能为空");
                return result;
            }
            //判断验证码是否正确
            PersonalVerificationCodeRecord personalVerificationCodeRecord = personalVerificationCodeRecordService.queryValidateCodeByPhoneAndType(personalLoginInfo.getPhone(), (short) 2);
            if (personalVerificationCodeRecord != null && personalVerificationCodeRecord.getCode().equals(smsCode)) {

                //判断手机号是否存在
                List<PersonalLoginInfo> infoExists = userService.getPersonalLoginInfoByPhone(personalLoginInfo.getPhone());

                if (!CollectionUtils.isEmpty(infoExists)) {
                    result.setStatus("error").setValue("此号码以注册过，请登录");
                    return result;

                } else {
                    String password = EncryptUtil.encrypt(personalLoginInfo.getPassword());
                    personalLoginInfo.setPassword(password);
                    personalLoginInfo.setWechatId(getOpenId());
                    personalLoginInfo.setRegistrationTime(new Date());
                    personalLoginInfo.setRoleId(Constant.USER_ROLE_DESIGNER);

                    WxMpUser wxMpUser = weChatService.getWxMpUser(getOpenId());
                    personalLoginInfo.setHeader(wxMpUser.getHeadImgUrl());

                    if (userService.saveSelective(personalLoginInfo) > 0) {

                        personalLoginInfo = userService.getPersonalLoginInfoByOpenId(personalLoginInfo.getWechatId());
                        if (personalLoginInfo.getId() != 0) {
                            result.setStatus("success").setValue("注册成功");
                            return result;
                        }
                    }else{
                        result.setStatus("error").setValue("注册成功失败");
                        return result;
                    }
                }
            }else{
                result.setStatus("error").setValue("验证码不对");
                return result;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return result;
    }

    @RequestMapping("personal")
    public String personal(Model model, HttpServletRequest req) {

        Long memberId = getMemberId();

        if (0 == memberId) {
            return "redirect:/user/login";
        }
        PersonalBaseInfo personalBaseInfo = userService.getPersonalBaseInfoByMemberId(memberId);
        if (personalBaseInfo == null) {
            personalBaseInfo = new PersonalBaseInfo();
            personalBaseInfo.setBirthday(new Date());
            personalBaseInfo.setMemberId(memberId);
        }

        PersonalLoginInfo loginInfo = userService.getPersonalLoginInfoById(memberId);

        WxMpUser wxMpUser = weChatService.getWxMpUser(getOpenId());
        if (!StringKit.isNotEmpty(loginInfo.getHeader())) {
            loginInfo.setHeader(wxMpUser.getHeadImgUrl());
        }

        if (!StringKit.isNotEmpty(personalBaseInfo.getName())) {
            personalBaseInfo.setName(wxMpUser.getNickname());
        }

        model.addAttribute("loginInfo", loginInfo);
        model.addAttribute("personalBaseInfo", personalBaseInfo);
        List<TeamBasicInformation> teamBasicInformations = teamService.getAllTeamBasicInfo();
        model.addAttribute("teamBasicInformations", teamBasicInformations);

        return "personal";
    }


    @RequestMapping("personaling")
    @ResponseBody
    public boolean personaling(Model model, HttpServletRequest req, PersonalBaseInfo personalBaseInfo) {

        Long teamId = personalBaseInfo.getTeamId();

        if (teamId != null) {
            TeamBasicInformation teamBasicInformation = teamService.getByTeamId(teamId);
            if (teamBasicInformation != null) {
                personalBaseInfo.setTeamName(teamBasicInformation.getName());
            }
        }
        personalBaseInfo.setAuthenticationType((short) 1);
        PersonalLoginInfo personalLoginInfo = new PersonalLoginInfo();
        personalLoginInfo.setId(personalBaseInfo.getMemberId());
        personalLoginInfo.setNickName(personalBaseInfo.getName());
        userService.updatePersonalLoginInfo(personalLoginInfo);
        int i = userService.updatePersonInfo(personalBaseInfo);

        return i == 0 ? false : true;
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
