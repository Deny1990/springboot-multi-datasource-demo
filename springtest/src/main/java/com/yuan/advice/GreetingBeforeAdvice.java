package com.yuan.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by yuanxin on 17/8/8.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice
{
    static Logger logger = LoggerFactory.getLogger(GreetingBeforeAdvice.class);
    public void before(Method method, Object[] objects, Object o)
        throws Throwable
    {
        String clientName = (String)objects[0];
        logger.info("Method is: "+method.getName()+"start");
        System.out.println("How are you "+ clientName+".");
    }
}
