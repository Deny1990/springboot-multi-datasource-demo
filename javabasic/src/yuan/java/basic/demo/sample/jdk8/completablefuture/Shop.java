package yuan.java.basic.demo.sample.jdk8.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Created by yuanxin on 17/6/13.
 */
public class Shop
{
    private String name;

    public Shop(String name)
    {
        this.name = name;
    }

    public String getPrice(String product)
    {
        System.out.println("getPrice Thread is " + Thread.currentThread());
        double price = calculatePreice(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];
        return name + ":" + price + ":" + code;
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
        Shop shop = new Shop("hllo");
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

    static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
//        new Shop("LetsSaveBig"),
//        new Shop("MyFavoriteShop"),
        new Shop("ButItAll"));

    private final static Executor executor =
        Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory()
        {
            @Override
            public Thread newThread(Runnable r)
            {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

    public static List<String> findPrices(String product)
    {
        List<CompletableFuture<String>> priceFutures = shops.stream()
            .map(shop -> {
                    System.out.println("CurrentThread is " + Thread.currentThread());
                    return CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor);
                }
            )
            .map(future -> {
                    System.out.println("before future.thenApply CurrentThread is " + Thread.currentThread());
                    return future.thenApply((String s) -> {
                        System.out.println("Inside future.thenApply CurrentThread is " + Thread.currentThread()+s);
                        return Quote.parse(s);
                    });
                }
            )
            .map(future -> {
                System.out.println("before future.thenCompose CurrentThread is " + Thread.currentThread());
                return future.thenCompose(
                    quote -> {
                        System.out.println("inside future.thenCompose CurrentThread is " + Thread.currentThread()+quote);
                        return CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor);
                    }
                );
            }).collect(Collectors.toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public static void main(String[] args)
    {
        findPrices("hello world");
    }
}
