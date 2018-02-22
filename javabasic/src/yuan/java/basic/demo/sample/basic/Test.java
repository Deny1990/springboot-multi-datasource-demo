package yuan.java.basic.demo.sample.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yuan on 17/12/10.
 */
public class Test
{
//    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer("hello ");
//        getString(sb);
//        System.out.println(sb);
//    }
//    public static void getString(StringBuffer s) {
//        s = new StringBuffer("ha");
//        s.append("world");
//    }

    public static void main(String[] args)
        throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        final int loopCount = 2000000;
        final CountDownLatch latch = new CountDownLatch(loopCount);
        for (int i = 0; i < loopCount; i++)
        {
            executorService.submit(new Runnable()
            {
                @Override
                public void run()
                {
                    System.out.println("hello Work" + latch.getCount());
                    latch.countDown();
                }
            });
        }
        latch.await();
    }
}
