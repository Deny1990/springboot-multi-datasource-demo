package com.yuan.proxy.jdkproxy;

import com.yuan.monitor.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yuanxin on 17/8/8.
 */
public class PerformanceHandler implements InvocationHandler
{
    private Object target;

    public PerformanceHandler(Object target)
    {
       this.target = target;
    }

    /**
     *
     * @param proxy  目标类生成的代理类
     * @param method 目标类代理方法
     * @param args   目标类代理方法的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable
    {
        System.out.println(proxy.getClass());
        PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
        Object obj = method.invoke(target,args);
        PerformanceMonitor.end();
        return obj;
    }
}
