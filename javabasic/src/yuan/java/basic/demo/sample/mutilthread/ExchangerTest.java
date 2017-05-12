package yuan.java.basic.demo.sample.mutilthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by yuanxin on 17/5/11.
 */
public class ExchangerTest
{
    public static void main(String[] args)
    {
        final Exchanger<List<Integer>> exchanger = new Exchanger<>();
        new Thread()
        {
            @Override
            public void run()
            {
                List<Integer> list = new ArrayList<Integer>();
                list.add(1);
                list.add(2);
                try
                {
                    list = exchanger.exchange(list);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("thread1" + list);
            }
        }.start();

        new Thread()
        {
            @Override
            public void run()
            {
                List<Integer> list2 = new ArrayList<Integer>();
                list2.add(4);
                list2.add(5);
                try
                {
                    list2= exchanger.exchange(list2);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("thread2" + list2);
            }
        }.start();
    }
}
