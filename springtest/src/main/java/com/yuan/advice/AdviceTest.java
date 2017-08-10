package com.yuan.advice;

import com.yuan.service.ForumService;
import com.yuan.service.NaiveWaiter;
import com.yuan.service.Waiter;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuan on 17/8/7.
 */
public class AdviceTest {
    public static void main(String[] args)
        throws Exception
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-application.xml");

        ForumService forumService = (ForumService)context.getBean("forumService");
        forumService.updateForum(11);

        Waiter waiter = (Waiter)context.getBean("waiter");
        waiter.serveTo("hello");
        waiter.greetTo("world");



        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvice(advice);

        Waiter proxy = (Waiter)pf.getProxy();
        proxy.greetTo("john");
        proxy.serveTo("tom");


    }
}
