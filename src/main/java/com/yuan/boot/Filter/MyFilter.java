package com.yuan.boot.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by yuanxin on 17/5/5.
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*",
        initParams = {@WebInitParam(name = "pre",value = "hello"),@WebInitParam(name = "after",value =  "world")},
        asyncSupported = true)
public class MyFilter implements Filter
{
    Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig)
        throws ServletException
    {
        logger.info("过滤器初始化");
        Enumeration<String>  enumerations = filterConfig.getInitParameterNames();
        int i = 0;
        while (enumerations.hasMoreElements()){
            i++;
            String element = enumerations.nextElement();
            String value = filterConfig.getInitParameter(element);
            logger.info("element{},is {}",i,element);
            logger.info("element{} value ,is {}",i,value);
        }
        ServletContext context = filterConfig.getServletContext();
        String contextPath = context.getContextPath();
        logger.info("contextPath is {}", contextPath);
        String serverInfo = context.getServerInfo();
        logger.info("serverInfo is {}", serverInfo);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        logger.info("doFilter start");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy()
    {
        logger.info("销毁过滤器");
    }
}
