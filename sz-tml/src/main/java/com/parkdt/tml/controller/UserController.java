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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        logger.info("login openid:" + openId);

        PersonalLoginInfo userInfo = userService.getPersonalLoginInfoByOpenId(openId);

        if (null != userInfo) {
            if (userInfo.getCertificationLoginFlag() != 0) {
                String phone = userInfo.getPhone();
                int count = userService.updateOpenIdByPhone(phone, openId);
                return "redirect:/user/personal";
            } else {
                PersonalLoginInfo personalLoginInfo1 = new PersonalLoginInfo();
                personalLoginInfo1.setWechatId(openId);
                model.addAttribute("personalLoginInfo", personalLoginInfo1);
                return "login";
            }
        } else {
            PersonalLoginInfo personalLoginInfo1 = new PersonalLoginInfo();
            personalLoginInfo1.setWechatId(openId);
            model.addAttribute("personalLoginInfo", personalLoginInfo1);

            return "login";
        }
    }

    @RequestMapping("certificat")
    public String certificat(Model model, HttpServletRequest req) {

        return "certificat";
    }

    @RequestMapping("logining")
    @ResponseBody
    public Result logining(Model model, HttpServletRequest req, PersonalLoginInfo personalLoginInfo) {
        Result result = new Result();
        logger.info("logining openid:" + personalLoginInfo.getWechatId());
        if (personalLoginInfo == null || StringUtils.isBlank(personalLoginInfo.getWechatId())) {
            return result.setStatus("error").setValue("openid不能为空");
        }

        if (personalLoginInfo == null || StringUtils.isBlank(personalLoginInfo.getPhone())) {
            return result.setStatus("error").setValue("手机号不能为空");
        }

        if (personalLoginInfo == null || StringUtils.isBlank(personalLoginInfo.getPassword())) {
            return result.setStatus("error").setValue("密码不能为空");
        }

        List<PersonalLoginInfo> infoExists = userService.getPersonalLoginInfoByPhone(personalLoginInfo.getPhone());

        if (!CollectionUtils.isEmpty(infoExists)) {

            if (infoExists.size() > 1) {
                return result.setStatus("error").setValue("此号码绑定多个账户，请联系管理员处理");
            }

            PersonalLoginInfo loginInfo = infoExists.get(0);

            try {
                String password = EncryptUtil.encrypt(personalLoginInfo.getPassword());

                if (!loginInfo.getPassword().equals(password)) {
                    return result.setStatus("error").setValue("密码不对");
                }
                if (loginInfo.getCertificationLoginFlag() == 0) {
                    return result.setStatus("certificat").setValue("用户未认证，请登录网站进行身份认证");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            String openId = personalLoginInfo.getWechatId();
            String phone = personalLoginInfo.getPhone();

            int count = userService.updateOpenIdByPhone(phone, openId);

            if (count > 0) {
                return result.setStatus("success").setValue("登录成功");
            } else {
                return result.setStatus("error").setValue("更新openid失败");
            }

        } else {
            return result.setStatus("error").setValue("没有此用户信息，请先注册");
        }
    }

    @RequestMapping("register")
    public String register(Model model, HttpServletRequest req, PersonalLoginInfo personalLoginInfo) {

        String openId = getOpenId();
        logger.info("register openid:" + openId);
        PersonalLoginInfo userInfo = userService.getPersonalLoginInfoByOpenId(openId);

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

        logger.info("registering openid:" + personalLoginInfo.getWechatId());

        if (personalLoginInfo == null || StringUtils.isBlank(personalLoginInfo.getWechatId())) {
            return result.setStatus("error").setValue("openid不能为空");
        }
        if (personalLoginInfo == null || StringUtils.isBlank(personalLoginInfo.getPhone())) {
            return result.setStatus("error").setValue("手机号不能为空");
        }
        try {

            String smsCode = req.getParameter("smsCode");

            if (smsCode == null || StringUtils.isBlank(smsCode)) {
                return result.setStatus("error").setValue("验证码不能为空");
            }
            //判断验证码是否正确
            PersonalVerificationCodeRecord personalVerificationCodeRecord = personalVerificationCodeRecordService.queryValidateCodeByPhoneAndType(personalLoginInfo.getPhone(), (short) 2);
            if (personalVerificationCodeRecord != null && personalVerificationCodeRecord.getCode().equals(smsCode)) {

                //判断手机号是否存在
                List<PersonalLoginInfo> infoExists = userService.getPersonalLoginInfoByPhone(personalLoginInfo.getPhone());

                if (!CollectionUtils.isEmpty(infoExists)) {
                    return result.setStatus("error").setValue("此号码以注册过，请登录");
                } else {
                    String password = EncryptUtil.encrypt(personalLoginInfo.getPassword());
                    personalLoginInfo.setPassword(password);
                    personalLoginInfo.setWechatId("_");
                    personalLoginInfo.setRegistrationTime(new Date());
                    personalLoginInfo.setRoleId(Constant.USER_ROLE_EVERYMAN);

                    WxMpUser wxMpUser = weChatService.getWxMpUser(getOpenId());
                    personalLoginInfo.setHeader(wxMpUser.getHeadImgUrl());

                    if (userService.saveSelective(personalLoginInfo) > 0) {

                        personalLoginInfo = userService.getPersonalLoginInfoByOpenId(personalLoginInfo.getWechatId());
                        if (personalLoginInfo.getId() != 0) {
                            return result.setStatus("certificat").setValue("注册成功,请登录网站进行身份认证");
                        }
                        return result.setStatus("certificat").setValue("注册成功,请登录网站进行身份认证");
                    } else {
                        return result.setStatus("error").setValue("注册成功失败");
                    }
                }
            } else {
                return result.setStatus("error").setValue("验证码不对");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return result;
    }

    @RequestMapping("personal")
    public String personal(Model model, HttpServletRequest req) {

        Long memberId = getMemberId();
        logger.info("personal memberId:" + memberId);
        if (0 == memberId) {
            return "redirect:/user/login";
        }

        PersonalLoginInfo loginInfo = userService.getPersonalLoginInfoById(memberId);

        PersonalBaseInfo personalBaseInfo = userService.getPersonalBaseInfoByMemberId(memberId);
        if (personalBaseInfo == null) {
            personalBaseInfo = new PersonalBaseInfo();
            personalBaseInfo.setBirthday(new Date());
            personalBaseInfo.setMemberId(memberId);
            personalBaseInfo.setPhone(loginInfo.getPhone());
        }

        if (!StringKit.isNotEmpty(personalBaseInfo.getPhone())) {
            personalBaseInfo.setPhone(loginInfo.getPhone());
        }

        WxMpUser wxMpUser = weChatService.getWxMpUser(getOpenId());
        if (!StringKit.isNotEmpty(loginInfo.getHeader())) {
            loginInfo.setHeader(wxMpUser.getHeadImgUrl());
        }

        model.addAttribute("loginInfo", loginInfo);
        model.addAttribute("personalBaseInfo", personalBaseInfo);
        List<TeamBasicInformation> teamBasicInformations = teamService.getAllTeamBasicInfo();
        model.addAttribute("teamBasicInformations", teamBasicInformations);

        return "personal";
    }


    @RequestMapping("personaling")
    @ResponseBody
    public Result personaling(Model model, HttpServletRequest req, PersonalBaseInfo personalBaseInfo) {

        Result result = new Result();
        logger.info("personaling memberId:" + personalBaseInfo.getMemberId());
        try {
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

            if (i == 0) {
                result.setStatus("error").setValue("信息绑定失败");
            } else {
                result.setStatus("success").setValue("信息绑定成功");
            }
        } catch (Exception e) {
            result.setStatus("error").setValue("信息绑定失败,请重试");
        }
        return result;
    }

    @RequestMapping("changePersonal")
    @ResponseBody
    public Result changePersonal(Model model, HttpServletRequest req, PersonalBaseInfo personalBaseInfo) {

        logger.info("changePersonal memberId:" + personalBaseInfo.getMemberId());
        HttpSession session = req.getSession();
        session.removeAttribute(Constant.SESSION_OPEN_ID);
        PersonalLoginInfo loginInfo = userService.getPersonalLoginInfoById(personalBaseInfo.getMemberId());
        logger.info("changePersonal:" + loginInfo.getWechatId());

        Result result = new Result();
        if (null != loginInfo) {
            userService.updateWechatIdEmpty(loginInfo.getWechatId());
        }
        result.setStatus("success").setValue("切换成功");
        return result;
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
