package com.parkdt.tml.controller.weChat;

import com.parkdt.tml.config.WeChatConfig;
import com.parkdt.tml.utils.HttpPostClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(HttpPostClient.class);

    @RequestMapping("myTake")
    public String take(Model model, HttpServletRequest req) {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatConfig.getAppid() + "&redirect_uri=";
        String redirect_uri = WeChatConfig.getWebUrl() + "biz/take";
        url += redirect_uri;
        url += "&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";

        logger.info("myTake : " + url);
        return "redirect:" + url;
    }

    @RequestMapping("myPublish")
    public String publish() {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatConfig.getAppid() + "&redirect_uri=";
        String redirect_uri = WeChatConfig.getWebUrl() + "biz/publish";
        url += redirect_uri;
        url += "&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
        logger.info("myPublish : " + url);
        return "redirect:" + url;
    }

    @RequestMapping("taskPublish")
    public String taskPublish() {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatConfig.getAppid() + "&redirect_uri=";
        String redirect_uri = WeChatConfig.getWebUrl() + "task/publish";
        url += redirect_uri;
        url += "&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
        logger.info("taskPublish : " + url);
        return "redirect:" + url;
    }

    @RequestMapping("taskEnter")
    public String taskenter() {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatConfig.getAppid() + "&redirect_uri=";
        String redirect_uri = WeChatConfig.getWebUrl() + "task/enter";
        url += redirect_uri;
        url += "&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
        logger.info("taskEnter : " + url);
        return "redirect:" + url;
    }

    @RequestMapping("personal")
    public String personal() {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatConfig.getAppid() + "&redirect_uri=";
        String redirect_uri = WeChatConfig.getWebUrl() + "user/personal";
        url += redirect_uri;
        url += "&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
        logger.info("personal : " + url);
        return "redirect:" + url;
    }

    @RequestMapping("login")
    public String login() {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatConfig.getAppid() + "&redirect_uri=";
        String redirect_uri = WeChatConfig.getWebUrl() + "user/login";
        url += redirect_uri;
        url += "&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
        logger.info("login : " + url);
        return "redirect:" + url;
    }
}
