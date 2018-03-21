package com.parkdt.tml.weChat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.parkdt.tml.config.WeChatConfig;
import com.parkdt.tml.taskService.WeChatTokenService;
import com.parkdt.tml.utils.HttpPostClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyMenu {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyMenu.class);

    /**
     * 创建自定义菜单
     */
    public static void createMenu() {
        JSONObject menuJson = new JSONObject();
        JSONArray button = new JSONArray();

        JSONObject taskCenter = new JSONObject();
        taskCenter.put("name", "任务中心");
        JSONArray taskCenterSubMenuArray = new JSONArray();

        JSONObject taskPublish = new JSONObject();
        taskPublish.put("type", "view");
        taskPublish.put("name", "任务发布");
        taskPublish.put("url", WeChatConfig.getWebUrl() + "auth/taskPublish");
        taskCenterSubMenuArray.add(taskPublish);

        JSONObject taskTake = new JSONObject();
        taskTake.put("type", "view");
        taskTake.put("name", "任务报名");
        taskTake.put("url", WeChatConfig.getWebUrl() + "auth/taskEnter");
        taskCenterSubMenuArray.add(taskTake);

        JSONObject myTake = new JSONObject();
        myTake.put("type", "view");
        myTake.put("name", "我参与的");
        myTake.put("url", WeChatConfig.getWebUrl() + "auth/myTake");
        taskCenterSubMenuArray.add(myTake);

        JSONObject myPublish = new JSONObject();
        myPublish.put("type", "view");
        myPublish.put("name", "我发布的");
        myPublish.put("url", WeChatConfig.getWebUrl() + "auth/myPublish");
        taskCenterSubMenuArray.add(myPublish);

        taskCenter.put("sub_button", taskCenterSubMenuArray);
        button.add(taskCenter);

        JSONObject like = new JSONObject();
        like.put("name", "立可空间");
        JSONArray likeSubMenuArray = new JSONArray();

        JSONObject recourse = new JSONObject();
        recourse.put("type", "view");
        recourse.put("name", "资源中心");
        recourse.put("url", WeChatConfig.getWebUrl() + "links/join");
        likeSubMenuArray.add(recourse);

        JSONObject platform = new JSONObject();
        platform.put("type", "view");
        platform.put("name", "立可平台");
        platform.put("url", WeChatConfig.getWebUrl() + "links/platform");
        likeSubMenuArray.add(platform);

        JSONObject about = new JSONObject();
        about.put("type", "view");
        about.put("name", "关于立可");
        about.put("url", WeChatConfig.getWebUrl() + "links/about");
        likeSubMenuArray.add(about);

        like.put("sub_button", likeSubMenuArray);
        button.add(like);

        JSONObject personal = new JSONObject();

        personal.put("type", "view");
        personal.put("name", "个人中心");
        personal.put("url", WeChatConfig.getWebUrl() + "auth/login");
        button.add(personal);

        menuJson.put("button", button);

        LOGGER.info("创建菜单：" + menuJson.toJSONString());
        String createUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + WeChatTokenService.getAccessToken();
        String result = HttpPostClient.doHttPostIO(createUrl, menuJson.toJSONString());
        LOGGER.info("创建菜单：" + result);
    }

    /**
     * 查询菜单
     */
    public static void queryMenu() {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + WeChatTokenService.getAccessToken();
        String result = HttpPostClient.doHttPostIO(url, null);
        LOGGER.info("查询菜单：" + result);
    }

}
