package com.parkdt.tml.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

@Configuration
public class WeChatConfig extends PropertyPlaceholderConfigurer {

    private static HashMap<String, Object> map;

    private static final String appid = "appid";
    private static final String appSecret = "appSecret";
    private static final String webUrl = "webUrl";

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {

        try {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("/weChatConfig.properties"));

            super.processProperties(beanFactoryToProcess, properties);
            map = new HashMap<String, Object>();
            for (Object k : properties.keySet()) {
                String key = k.toString();
                String value = properties.getProperty(key);
                map.put(key, value);
            }

        } catch (IOException e) {

        }
    }

    private static Object get(String key) {
        return map.get(key);
    }

    public static String getAppid() {
        return (String) map.get(appid);
    }

    public static String getAppSecret() {
        return (String) map.get(appSecret);
    }

    public static String getWebUrl() {
        return (String) get(webUrl);
    }

}
