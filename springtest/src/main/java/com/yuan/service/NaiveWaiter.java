package com.yuan.service;

/**
 * Created by yuanxin on 17/8/8.
 */
public class NaiveWaiter implements Waiter
{
    public void greetTo(String name)
    {
        System.out.println("greet to "+ name +"..");
    }

    public void serveTo(String name)
    {
        System.out.println("serving to "+ name +"..");
    }
}
