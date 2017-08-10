package com.yuan.advice;

import com.yuan.service.ForumServiceTwo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuanxin on 17/8/10.
 */
public class TestIntroduce
{
    public static void main(String[] args)
    {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-application.xml");

        ForumServiceTwo forumService = (ForumServiceTwo)context.getBean("forumService");
        forumService.removeForum(11);

        Monitorable monitorable = (Monitorable)forumService;

        monitorable.setMonitorActive(true);
        forumService.removeForum(22);

    }
}
