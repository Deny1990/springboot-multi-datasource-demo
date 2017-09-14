package com.yuan.bundle;

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

        for (int i = 0; i < 2; i++)
        {
            String str1 = ms.getMessage("greeting.common", params, Locale.US);
            System.out.println(str1);
            Thread.currentThread().sleep(30000);
        }
    }

}
