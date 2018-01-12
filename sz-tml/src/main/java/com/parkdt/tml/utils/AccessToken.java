package com.parkdt.tml.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public class AccessToken {

    private static String access_token = "";

    @Scheduled(fixedRate = 7000000)
    public static void refreshAccessToken() {
        StringBuffer url = new StringBuffer("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential");
        url.append("&appid=" + "wx99ad709a554e69da");
        url.append("&secret=" + "e0d21e49c17b303dfbde5bffb7466a09");

        int count = 0;
        synchronized (access_token) {
            do {
                String result = HttpPostClient.doHttpGet(url.toString());
                System.out.println(result);
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
