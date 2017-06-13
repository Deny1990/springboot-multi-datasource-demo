package yuan.java.basic.demo.sample.jdk8.completablefuture;

import java.util.concurrent.*;

/**
 * Created by yuanxin on 17/6/13.
 */
public class FutureDemo
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>()
        {
            public Double call()
            {
                return doSomeLongCompuation();
            }
        });
        doSomethingElse();
        try
        {
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result);
        }
        catch (ExecutionException e)
        {

        }
        catch (InterruptedException ee)
        {

        }catch (TimeoutException eee){

        }
    }

    static void doSomethingElse()
    {
        System.out.println("hello world currentThread is "+ Thread.currentThread());
    }

    static Double doSomeLongCompuation()
    {
        System.out.println("current thread is "+Thread.currentThread());
        return Double.valueOf(2);
    }
}
