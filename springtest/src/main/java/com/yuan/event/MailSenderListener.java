package com.yuan.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

/**
 * Created by yuanxin on 17/9/15.
 */
public class MailSenderListener implements ApplicationListener<MailSendEvent>
{
    static Logger logger = LoggerFactory.getLogger(MailSenderListener.class);
    public void onApplicationEvent(MailSendEvent event)
    {
        MailSendEvent mse = event;
        logger.info("MailSenderListener:向{}发送完一封邮件",mse.getTo());
    }
}
