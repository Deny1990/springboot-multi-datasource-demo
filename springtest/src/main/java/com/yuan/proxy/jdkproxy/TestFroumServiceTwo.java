package com.yuan.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * Created by yuanxin on 17/8/8.
 */
public class TestFroumServiceTwo
{
    public static void main(String[] args)
    {
       ForumServiceTwo target = new ForumServiceTwoImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        ForumServiceTwo proxy = (ForumServiceTwo)Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            handler
        );
        proxy.removeForum(2);
        proxy.removeTopic(2);
    }
}
