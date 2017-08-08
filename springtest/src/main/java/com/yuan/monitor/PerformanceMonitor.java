package com.yuan.monitor;

/**
 * Created by yuanxin on 17/8/8.
 */
public class PerformanceMonitor
{
    private static ThreadLocal<MethodPerformance> performanceMethod = new ThreadLocal<MethodPerformance>();

    public static void begin(String method)
    {
        System.out.println("begin monitor");
        MethodPerformance mp = new MethodPerformance(method);
        performanceMethod.set(mp);
    }

    public static void end()
    {
        System.out.println("end monitor");
        MethodPerformance mp = performanceMethod.get();
        mp.printPerformance();
    }
}
