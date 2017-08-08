package com.yuan.proxy.cglib;

import com.yuan.monitor.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by yuanxin on 17/8/8.
 */
public class CglibProxy implements MethodInterceptor
{
    private Enhancer enhancer = new Enhancer();

    private Object target;

    public Object getProxy(Class clazz)
    {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
        throws Throwable
    {

        PerformanceMonitor.begin(o.getClass().getName()+"."+method.getName());
        Object result = methodProxy.invokeSuper(o,objects);
//        Object result = method.invoke(target,objects);

        PerformanceMonitor.end();
        return result;
    }

    public void setTarget(Object target)
    {
        this.target = target;
    }
}
