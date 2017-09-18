package com.yuan.advice.composable;

import com.yuan.advice.controlflow.WaiterDelegate;
import com.yuan.service.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuanxin on 17/9/18.
 */
public class ComposableTest
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-composable.xml");
        Waiter waiter = (Waiter) context.getBean("waiter4");

        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter);
        waiter.serveTo("hello");
        waiter.greetTo("hello");
        waiterDelegate.service("hello");
    }
}
