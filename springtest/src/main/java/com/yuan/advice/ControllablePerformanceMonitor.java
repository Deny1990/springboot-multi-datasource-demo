package com.yuan.advice;

import com.yuan.monitor.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by yuanxin on 17/8/10.
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable
{

    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

    public void setMonitorActive(boolean active)
    {
        MonitorStatusMap.set(active);
    }

    public Object invoke(MethodInvocation mi)
        throws Throwable
    {
        Object obj = null;
        if (MonitorStatusMap.get() != null && MonitorStatusMap.get())
        {
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            obj = super.invoke(mi);
            PerformanceMonitor.end();
        }
        else
        {
            obj = super.invoke(mi);
        }
        return obj;
    }
}
