package yuan.java.basic.demo.sample.mutilthread.demoOne;

/**
 * Created by yuanxin on 17/5/10.
 */
public class SynchronizedDemo1
{
    public synchronized static void foo1(){
        System.out.println("Thread is "+Thread.currentThread().getName());
        System.out.println("I am SynchronizedDemo1 foo1");
    }
    public synchronized static void  foo2(){
        System.out.println("Thread is "+Thread.currentThread().getName());
        System.out.println("I am SynchronizedDemo1 foo2");
    }
}
