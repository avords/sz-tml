package com.parkdt.tml.controller.weChat;

import com.parkdt.tml.config.WeChatConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @RequestMapping("myTake")
    public String take(Model model, HttpServletRequest req) {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatConfig.getAppid() + "&redirect_uri=";
        String redirect_uri = WeChatConfig.getWebUrl() + "biz/take";
        url += redirect_uri;
        url += "&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
        System.out.println();
        System.out.println("publish : " + url);
        return "redirect:" + url;
    }

    @RequestMapping("myPublish")
    public String publish() {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatConfig.getAppid() + "&redirect_uri=";
        String redirect_uri = WeChatConfig.getWebUrl() + "biz/publish";
        url += redirect_uri;
        url += "&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
        System.out.println();
        System.out.println("publish : " + url);
        return "redirect:" + url;
    }

    @RequestMapping("taskPublish")
    public String taskPublish() {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatConfig.getAppid() + "&redirect_uri=";
        String redirect_uri = WeChatConfig.getWebUrl() + "task/publish";
        url += redirect_uri;
        url += "&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
        System.out.println();
        System.out.println("publish : " + url);
        return "redirect:" + url;
    }

    @RequestMapping("taskEnter")
    public String taskenter() {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatConfig.getAppid() + "&redirect_uri=";
        String redirect_uri = WeChatConfig.getWebUrl() + "task/enter";
        url += redirect_uri;
        url += "&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
        System.out.println();
        System.out.println("publish : " + url);
        return "redirect:" + url;
    }

    @RequestMapping("personal")
    public String personal() {

        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatConfig.getAppid() + "&redirect_uri=";
        String redirect_uri = WeChatConfig.getWebUrl() + "user/register";
        url += redirect_uri;
        url += "&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
        System.out.println();
        System.out.println("publish : " + url);
        return "redirect:" + url;
    }

    @RequestMapping("info")
    public String info() {
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeChatConfig.getAppid() + "&redirect_uri=";
        String redirect_uri = WeChatConfig.getWebUrl() + "user/personal";
        url += redirect_uri;
        url += "&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
        System.out.println();
        System.out.println("publish : " + url);
        return "redirect:" + url;
    }
}
