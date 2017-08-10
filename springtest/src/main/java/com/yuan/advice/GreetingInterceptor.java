package com.yuan.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by yuanxin on 17/8/10.
 */
public class GreetingInterceptor implements MethodInterceptor
{
    public Object invoke(MethodInvocation invocation)
        throws Throwable
    {
        Method method = invocation.getMethod();
        System.out.println("method = "+method);
        Object[] args = invocation.getArguments();//目标方法入参
        String clientName = (String)args[0];
        System.out.println("how are you mr " + clientName);
        Object obj = invocation.proceed();
        System.out.println("enjoy you yourself");
        return obj;
    }
}
