package com.parkdt.tml.weChat;

import com.alibaba.fastjson.JSONObject;
import com.parkdt.tml.config.WeChatConfig;
import com.parkdt.tml.utils.HttpPostClient;
import com.parkdt.tml.weChat.message.MessageFactory;
import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeChatService {

    /**
     * 验证签名
     *
     * @param request
     * @return
     */
    public String check(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        String[] arr = new String[]{WeChatConfig.getToken(), timestamp, nonce};
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        String pwd = DigestUtils.shaHex(content.toString());
        if (pwd.equals(signature)) {
            return echostr;
        }
        return "";
    }

    /**
     * 创建回复消息
     *
     * @param request
     */
    public String buildArticleMessage(HttpServletRequest request) {
        Map<String, String> param = parse(request);
        return MessageFactory.createMessage(param);
    }

    /**
     * 获取用户的openid
     *
     * @param code
     * @return
     */
    public String getOpenId(String code) {
        System.out.println("-------code = " + code + "--------------");
        StringBuffer url = new StringBuffer("https://api.weixin.qq.com/sns/oauth2/access_token?");
        url.append("appid=" + WeChatConfig.getAppid() + "&secret=" + WeChatConfig.getAppSecret());
        url.append("&code=" + code + "&grant_type=authorization_code");
        String result = HttpPostClient.doHttpPost(url.toString(), null, null);
        System.out.println(result);

        JSONObject openidJson = JSONObject.parseObject(result);
        String openid = openidJson.getString("openid");
        System.out.println();
        System.out.println("openid = " + openid);

        return openid;
    }

    private static Map<String, String> parse(HttpServletRequest request) {
        // 将解析结果存储在HashMap中   
        Map<String, String> map = new HashMap<String, String>();
        // 从request中取得输入流   
        InputStream inputStream;
        try {
            inputStream = request.getInputStream();
            // 读取输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            // 得到xml根元素
            Element root = document.getRootElement();
            // 得到根元素的所有子节点
            @SuppressWarnings("unchecked")
            List<Element> elementList = root.elements();
            // 遍历所有子节点
            for (Element e : elementList)
                map.put(e.getName(), e.getText());
            System.out.println("我是 " + map.get("Content") + ", 我的openid=" + map.get("FromUserName"));
            // 释放资源
            inputStream.close();
            inputStream = null;
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (DocumentException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return map;
    }

}
