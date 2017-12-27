package yuan.java.basic.demo.sample.basic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yuanxin on 17/12/22.
 */
public class AtomicIntegerTest
{
    public static void main(String[] args)
    {
        final AtomicInteger n = new AtomicInteger(0);

        for (int i = 0; i <10 ; i++)
        {
            System.out.println(n.getAndIncrement());
        }

    }
}
