package yuan.java.basic.demo.sample.mutilthread.demoOne;

/**
 * Created by yuanxin on 17/5/10.
 */
public class ThreadTwo extends Thread
{

    public ThreadTwo(String name){
        super(name);
    }
    public void run()
    {
        System.out.println("I am thread two start");
        SynchronizedDemo1.foo2();
        System.out.println("I am thread two end");
    }

}
