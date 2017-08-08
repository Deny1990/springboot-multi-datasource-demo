package com.yuan.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by yuanxin on 17/8/8.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice
{
    public void before(Method method, Object[] objects, Object o)
        throws Throwable
    {
        String clientName = (String)objects[0];
        System.out.println("How are you "+ clientName+".");
    }
}
