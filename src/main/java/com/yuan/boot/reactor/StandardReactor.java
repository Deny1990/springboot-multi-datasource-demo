package com.yuan.boot.reactor;

/**
 * Created by yuanxin on 17/5/7.
 */
public class StandardReactor
{
    public static void main(String[] args)
    {
        new Server(9911).start();
    }
}
