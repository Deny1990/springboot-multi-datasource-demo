package com.yuan.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by yuanxin on 17/8/10.
 */
public class GreetingAfterAdvice implements AfterReturningAdvice
{
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object o1)
        throws Throwable
    {
        System.out.println("please enjoy yourself");
        System.out.println(returnValue);
    }
}
