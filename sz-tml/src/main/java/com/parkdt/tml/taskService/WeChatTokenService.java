package com.parkdt.tml.taskService;

import com.alibaba.fastjson.JSONObject;
import com.parkdt.tml.config.WeChatConfig;
import com.parkdt.tml.utils.HttpPostClient;
import com.parkdt.tml.utils.StringKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WeChatTokenService {
    private Logger logger = LoggerFactory.getLogger(WeChatTokenService.class);

    private static String access_token = "";

    @Scheduled(fixedRate = 7000000)
    public void refreshAccessToken() {

        StringBuffer url = new StringBuffer("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential");

        url.append("&appid=" + WeChatConfig.getAppid());
        url.append("&secret=" + WeChatConfig.getAppSecret());

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

    public static String getAccessToken() {
        synchronized (access_token) {
            return access_token;
        }
    }

}
