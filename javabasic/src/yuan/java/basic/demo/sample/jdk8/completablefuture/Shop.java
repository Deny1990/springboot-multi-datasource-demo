package yuan.java.basic.demo.sample.jdk8.completablefuture;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by yuanxin on 17/6/13.
 */
public class Shop
{
    public double getPrice(String product)
    {
        return calculatePreice(product);
    }

    private double calculatePreice(String product)
    {
        Util.delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getPriceAsync(String product)
    {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePreice(product);
            System.out.println("current thread is " + Thread.currentThread() + "当前时间为 " + System.currentTimeMillis());
            futurePrice.complete(price);
        }).start();
        System.out.println("current thread is " + System.currentTimeMillis());
        return futurePrice;
    }

    public Future<Double> getPriceAsyncTwo(String product)
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(
            new Callable<Double>()
            {
                @Override
                public Double call()
                    throws Exception
                {
                    double price = calculatePreice(product);
                    System.out.println(
                        "current thread is " + Thread.currentThread() + "当前时间 k " + System.currentTimeMillis());
                    return price;
                }
            }
        );
        System.out.println("current thread is  iiiiii " + System.currentTimeMillis());
        return future;
    }

    public static void getPrice()
    {
        Shop shop = new Shop();
        long start = System.nanoTime();
        Future<Double> price = shop.getPriceAsync("hello world");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        try
        {
            double i = price.get();
            System.out.println(price);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public static void doSomethingElse()
    {
        System.out.println("return doSomethingElse");
    }

    public static void main(String[] args)
    {
        getPrice();
    }
}
