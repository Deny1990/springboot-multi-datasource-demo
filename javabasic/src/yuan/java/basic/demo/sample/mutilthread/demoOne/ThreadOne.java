package yuan.java.basic.demo.sample.mutilthread.demoOne;

/**
 * Created by yuanxin on 17/5/10.
 */
public class ThreadOne extends Thread
{
    public ThreadOne(String name)
    {
        super(name);//调用父类带参数的构造方法
    }

    public void run()
    {
        System.out.println("I am thread one start");
        SynchronizedDemo1.foo1();
       System.out.println("I am thread one end");
    }

}
