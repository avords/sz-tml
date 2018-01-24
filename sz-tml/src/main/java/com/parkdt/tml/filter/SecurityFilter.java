package com.parkdt.tml.filter;

import org.apache.commons.lang3.StringUtils;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2018/1/22.
 */
@Order(2)
//重点
@WebFilter(filterName = "loginFilter", urlPatterns = {"/*"})
public class SecurityFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        if ((servletRequest instanceof HttpServletRequest) && (servletResponse instanceof HttpServletResponse)) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String code = request.getParameter("code");
            HttpSession session = request.getSession();
            String sessionCode = (String) session.getAttribute("code");
            if(StringUtils.isBlank(sessionCode)){
                session.setAttribute("code",code);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
    
}
