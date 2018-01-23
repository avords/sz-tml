package com.parkdt.tml.filter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/1/23.
 */
@Component
@ConfigurationProperties(prefix="loginfilter")
public class LoginFilterConfig {
    public String[] excludes = new String[]{};

    public String[] getExcludes() {
        return excludes;
    }

    public void setExcludes(String[] excludes) {
        this.excludes = excludes;
    }
}
