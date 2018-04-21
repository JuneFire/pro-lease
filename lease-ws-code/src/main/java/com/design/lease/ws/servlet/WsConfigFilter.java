package com.design.lease.ws.servlet;

import com.design.lease.servlet.WsHandlerAdapter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WsConfigFilter implements Filter{

    private WsHandlerAdapter wsHandlerAdapter;

    public void init(FilterConfig filterConfig) throws ServletException {
        if (wsHandlerAdapter == null){
            ServletContext servletContext = filterConfig.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
            wsHandlerAdapter = (WsHandlerAdapter) webApplicationContext.getBean("wsHandlerAdapter");
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        wsHandlerAdapter.doHandler(httpServletRequest,httpServletResponse);
    }

    public void destroy() {

    }

}
