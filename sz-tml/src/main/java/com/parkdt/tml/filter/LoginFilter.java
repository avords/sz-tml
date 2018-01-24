package com.parkdt.tml.filter;

import com.parkdt.tml.domain.PersonalLoginInfo;
import com.parkdt.tml.service.UserService;
import com.parkdt.tml.weChat.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/1/22.
 */
@Order(1)
//重点
@WebFilter(filterName = "loginFilter", urlPatterns = {"/user/*","/biz/*","/links/*","/task/*"})
public class LoginFilter implements Filter {
    
    @Autowired
    private WeChatService weChatService;
    @Autowired
    private UserService userService;
    /**
     * 封装，不需要过滤的list列表
     */
    @Autowired
    private LoginFilterConfig loginFilterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        if ((servletRequest instanceof HttpServletRequest) && (servletResponse instanceof HttpServletResponse)) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String uri = request.getRequestURI();
            if(!isExcludes(uri)) {//如果不排除
                String openId = (String) request.getSession().getAttribute("openId");
                PersonalLoginInfo personalLoginInfo = userService.getPersonalLoginInfoByOpenId(openId);
                if(personalLoginInfo!=null){//已经绑定了吗
                    filterChain.doFilter(servletRequest, servletResponse);
                }else{
                    response.sendRedirect("/user/login");
                    return;
                }
            }else{
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 是否需要排除
     * @param url
     * @return
     */
    private boolean isExcludes(String url) {
        for (String path : loginFilterConfig.getExcludes()) {
            if(url.matches(path)){
                return true;
            }
        }
        return false;
    }
    
}
