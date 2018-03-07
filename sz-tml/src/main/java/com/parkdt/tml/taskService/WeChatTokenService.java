package com.parkdt.tml.taskService;

import com.alibaba.fastjson.JSONObject;
import com.parkdt.tml.config.WeChatConfig;
import com.parkdt.tml.domain.OffiContent;
import com.parkdt.tml.service.ContentService;
import com.parkdt.tml.utils.HttpPostClient;
import com.parkdt.tml.utils.StringKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WeChatTokenService {
    private Logger logger = LoggerFactory.getLogger(WeChatTokenService.class);

    @Autowired
    private ContentService contentService;

    private static String access_token = "";
    private static String SubscribeText = "";

    @Scheduled(fixedRate = 7000000)
    public void refreshAccessToken() {

        StringBuffer url = new StringBuffer("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential");

        url.append("&appid=" + WeChatConfig.getAppid());
        url.append("&secret=" + WeChatConfig.getAppSecret());

        int count1 = 0;
        synchronized (SubscribeText) {
            do {
                OffiContent content = contentService.getContentByContentId(2000L);
                if (StringKit.isNotEmpty(content.getContent())) {
                    SubscribeText = content.getContent();
                    return;
                }
                count1++;
            } while (count1 < 10);
        }

        int count = 0;
        synchronized (access_token) {
            do {
                String result = HttpPostClient.doHttpGet(url.toString());
                logger.info(result);
                JSONObject json = JSONObject.parseObject(result);
                String token = json.getString("access_token");
                if (StringKit.isNotEmpty(token)) {
                    access_token = token;
                    return;
                }
                count++;
            } while (count < 10);
        }
    }

    public static String getSubscribeText() {

        synchronized (SubscribeText) {
            return SubscribeText;
        }
    }


    public static String getAccessToken() {
        synchronized (access_token) {
            return access_token;
        }
    }

}
