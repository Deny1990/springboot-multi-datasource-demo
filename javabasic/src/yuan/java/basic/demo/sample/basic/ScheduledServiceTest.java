package yuan.java.basic.demo.sample.basic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuanxin on 18/1/3.
 */
public class ScheduledServiceTest
{
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

    public static void timeRun(Runnable r, long timeout, TimeUnit unit)
    {
        final Thread taskThread = Thread.currentThread();
        System.out.println("before executor.schedule taskThread name " + taskThread.getName());
        executor.schedule(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("当前线程" + Thread.currentThread().getName());
                System.out.println("taskThread name " + taskThread.getName());
                taskThread.interrupt();
            }
        }, timeout, unit);
        r.run();
    }

    public static void timeRun2(Runnable r, long timeout, TimeUnit unit)
        throws InterruptedException
    {
        class RethrowableTask implements Runnable
        {

            private volatile Throwable t;

            @Override
            public void run()
            {
                try
                {
                    r.run();
                }
                catch (Throwable t)
                {
                    this.t = t;
                }
            }

            void rethrow()
            {
                if (t != null)
                {
                    throw launderThrowable(t) ;
                }
            }
        }
        RethrowableTask task = new RethrowableTask();

        System.out.println("before taskThread is "+Thread.currentThread().getName());
        final Thread taskThread = new Thread(task);
        taskThread.start();

        System.out.println("before executor.schedule taskThread name " + taskThread.getName());
        executor.schedule(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("当前线程" + Thread.currentThread().getName());
                System.out.println("taskThread name " + taskThread.getName());
                taskThread.interrupt();
            }
        }, timeout, unit);

        taskThread.join(unit.toMillis(timeout));
        task.rethrow();
    }

    public static void main(String[] args)
    {
        try
        {
            timeRun2(new Runnable()
            {
                @Override
                public void run()
                {
                    System.out.println("run2"+Thread.currentThread().getName());
                }
            }, 1, TimeUnit.SECONDS);
        }catch (Exception e){
            System.out.println(e);
        }

    }



    public static RuntimeException launderThrowable(Throwable t)
    {
        if (t instanceof RuntimeException)
        {
            return (RuntimeException)t;
        }
        else if (t instanceof Error)
        {
            throw (Error)t;
        }
        else
        {
            throw new IllegalStateException("Not unchecked ", t);
        }
    }

}
