package yuan.java.basic.demo.sample.mutilthread.base;

/**
 * Created by yuanxin on 17/7/27.
 */
public class WaitTest
{
    public static void main(String[] args)
    {
        Object b = new Object();
        try
        {
            System.out.println("helloworld");
            b.wait();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
