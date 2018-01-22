package com.parkdt.tml.weChat.message.toMessage.customServiceMessage;

import com.alibaba.fastjson.JSONObject;
import com.parkdt.tml.taskService.WeChatTokenService;
import com.parkdt.tml.utils.HttpPostClient;

public class CustomServiceMessageFactory {

    /**
     * 商户账号绑定成功消息
     *
     * @param openid
     */
    public static void merchantBindSuccess(String openid) {
        JSONObject json = new JSONObject();
        json.put("touser", openid);
        json.put("msgtype", "text");

        String content = "账号绑定成功！你可以使用该微信号收取新订单消息啦！";
        JSONObject textJson = new JSONObject();
        textJson.put("content", content);

        json.put("text", textJson);

        sendTextMessage(json.toJSONString());
    }

    /**
     * 发送文本客服消息
     *
     * @param json
     */
    public static void sendTextMessage(String json) {
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + WeChatTokenService.getAccessToken();
        HttpPostClient.doHttPostIO(url, json);
    }

}
