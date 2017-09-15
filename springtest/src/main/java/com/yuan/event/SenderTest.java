package com.yuan.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuanxin on 17/9/15.
 */
public class SenderTest
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-event.xml");
        MailSender sender = (MailSender)ctx.getBean("mailSender");
        sender.sendMail("hello");
    }
}
