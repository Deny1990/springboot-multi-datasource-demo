package yuan.java.basic.demo.sample.mutilthread.demoThree;

/**
 * Created by yuanxin on 17/5/10.
 */
public class SynchronizedDemo3
{
    public void foo5()
    {
        synchronized (this)
        {
            System.out.println("I am SynchronizedDemo3 foo5");
        }
    }

    public void foo6()
    {
        synchronized (SynchronizedDemo3.class)
        {
            System.out.println("thread is " + Thread.currentThread().getName());
            try
            {
                Thread.sleep(10000l);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("thread is " + Thread.currentThread().getName() + "线程休眠结束");
            System.out.println("I am SynchronizedDemo3 foo6");
        }
    }

    public synchronized void foo7()
    {
        System.out.println("thread is " + Thread.currentThread().getName());
        try
        {
            Thread.sleep(10000l);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("thread is " + Thread.currentThread().getName() + "线程休眠结束");
        System.out.println("I am SynchronizedDemo3 foo6");
    }
}
