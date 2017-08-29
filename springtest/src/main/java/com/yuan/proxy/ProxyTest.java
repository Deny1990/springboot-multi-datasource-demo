package com.yuan.proxy;

import com.yuan.proxy.cglib.CglibProxy;
import com.yuan.proxy.jdkproxy.PerformanceHandler;
import com.yuan.service.ForumServiceTwo;
import com.yuan.service.ForumServiceTwoImpl;

import java.lang.reflect.Proxy;

/**
 * Created by yuanxin on 17/8/10.
 */
public class ProxyTest
{
    public static void main(String[] args)
    {
//        testCglibProxy();
        testJdkProxy();
    }

    private static void testCglibProxy()
    {

        CglibProxy proxy = new CglibProxy();
        ForumServiceTwoImpl forumServiceTwo = (ForumServiceTwoImpl)proxy.getProxy(ForumServiceTwoImpl.class);
        forumServiceTwo.removeTopic(2);
        forumServiceTwo.removeForum(22);
    }

    private static void testJdkProxy()
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
