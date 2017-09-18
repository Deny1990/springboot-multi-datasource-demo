package com.yuan.advice.controlflow;

import com.yuan.service.Waiter;

/**
 * Created by yuanxin on 17/9/18.
 */
public class WaiterDelegate
{
    private Waiter waiter;

    public void service(String clientName)
    {
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }

    public Waiter getWaiter()
    {
        return waiter;
    }

    public void setWaiter(Waiter waiter)
    {
        this.waiter = waiter;
    }
}
