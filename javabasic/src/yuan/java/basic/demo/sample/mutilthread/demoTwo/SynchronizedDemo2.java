package yuan.java.basic.demo.sample.mutilthread.demoTwo;

/**
 * Created by yuanxin on 17/5/10.
 */
public class SynchronizedDemo2
{
    public synchronized void foo3()
    {
        System.out.println("Thread is "+Thread.currentThread().getName());
        System.out.println("I am SynchronizedDemo2 foo3");
        try
        {
            Thread.sleep(10000l);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("当前线程休眠10000l结束");
    }
    public synchronized void foo4(){
        System.out.println("Thread is "+Thread.currentThread().getName());
        System.out.println("I am SynchronizedDemo2 foo4");
    }
}
