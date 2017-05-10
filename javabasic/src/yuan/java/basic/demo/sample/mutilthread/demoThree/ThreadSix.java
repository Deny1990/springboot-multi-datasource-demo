package yuan.java.basic.demo.sample.mutilthread.demoThree;

/**
 * Created by yuanxin on 17/5/10.
 */
public class ThreadSix extends Thread
{
    SynchronizedDemo3 synchronizedDemo3;

    public ThreadSix(String name)
    {
        super(name);//调用父类带参数的构造方法
    }

    public void run()
    {
        System.out.println("I am thread Six start");
        synchronizedDemo3.foo7();
        System.out.println("I am thread Six end");
    }

    public SynchronizedDemo3 getSynchronizedDemo3()
    {
        return synchronizedDemo3;
    }

    public void setSynchronizedDemo3(SynchronizedDemo3 synchronizedDemo3)
    {
        this.synchronizedDemo3 = synchronizedDemo3;
    }
}
