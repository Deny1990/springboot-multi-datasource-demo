package yuan.java.basic.demo.sample.mutilthread.demoTwo;

/**
 * Created by yuanxin on 17/5/10.
 */
public class ThreadFour extends Thread
{
    SynchronizedDemo2 synchronizedDemo2;

    public ThreadFour(String name)
    {
        super(name);//调用父类带参数的构造方法
    }

    public void run()
    {
        System.out.println("I am thread four start");
        synchronizedDemo2.foo3();
        System.out.println("I am thread four end");
    }

    public SynchronizedDemo2 getSynchronizedDemo2()
    {
        return synchronizedDemo2;
    }

    public void setSynchronizedDemo2(SynchronizedDemo2 synchronizedDemo2)
    {
        this.synchronizedDemo2 = synchronizedDemo2;
    }
}
