package com.yuan.advice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuan on 17/8/7.
 */
public class AdviceTest {
    public static void main(String[] args)
        throws Exception
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-application.xml");
        ForumService  forumService = (ForumService)context.getBean("forumService");
        forumService.updateForum(11);
    }
}
