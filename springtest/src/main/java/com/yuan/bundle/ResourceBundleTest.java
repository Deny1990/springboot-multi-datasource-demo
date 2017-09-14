package com.yuan.bundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by yuanxin on 17/9/14.
 */
public class ResourceBundleTest
{
    static  Logger logger = LoggerFactory.getLogger(ResourceBundleTest.class);

    public static void main(String[] args)
        throws InterruptedException
    {
        test();
    }
    private static void test()
        throws InterruptedException
    {
        String[] configs = {"spring-bundle.xml"};

        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);

        MessageSource ms = (MessageSource)ctx.getBean("myResource");

        Object[] params = {"John", new GregorianCalendar().getTime()};
        logger.debug("hello world");
        for (int i = 0; i < 2; i++)
        {
            String str1 = ms.getMessage("greeting.common", params, Locale.US);
            System.out.println(str1);
            Thread.currentThread().sleep(3000);
        }
    }

}
