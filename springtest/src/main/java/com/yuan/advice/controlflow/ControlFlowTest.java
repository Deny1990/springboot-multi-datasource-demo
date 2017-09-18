package com.yuan.advice.controlflow;

import com.yuan.service.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuanxin on 17/9/18.
 */
public class ControlFlowTest
{
    public static void main(String[] args)
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-controlflow.xml");
        Waiter waiter = (Waiter) context.getBean("waiter3");

        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter);
        waiter.serveTo("hello");
        waiter.greetTo("hello");
        waiterDelegate.service("hello");
    }

}
