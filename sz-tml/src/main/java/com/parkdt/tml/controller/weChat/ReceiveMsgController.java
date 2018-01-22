package com.parkdt.tml.controller.weChat;

import com.parkdt.tml.weChat.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ReceiveMsgController {

    @Autowired
    private WeChatService service;

    @RequestMapping(value = "revmsg", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String index(HttpServletRequest request) {
        String method = request.getMethod();
        if (method.equals("GET")) {
            return service.check(request);
        }
        return service.buildArticleMessage(request);
    }

}
