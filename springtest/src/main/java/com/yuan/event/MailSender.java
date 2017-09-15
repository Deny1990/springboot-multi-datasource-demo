package com.yuan.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by yuanxin on 17/9/15.
 */
public class MailSender implements ApplicationContextAware
{
    Logger logger = LoggerFactory.getLogger(MailSender.class);

    private ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException
    {
        this.ctx = applicationContext;
    }

    public void sendMail(String to)
    {
        logger.info("MailSender:模拟发送邮件...");
        MailSendEvent mse = new MailSendEvent(this.ctx, to);
        ctx.publishEvent(mse);
    }
}
