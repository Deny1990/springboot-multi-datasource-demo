package yuan.java.basic.demo.sample.mutilthread.ackfile;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * Created by yuanxin on 17/6/19.
 */
public class AckFileMutliTest
{
    private final static Executor executor =
        Executors.newFixedThreadPool(Math.min(4, 10), new ThreadFactory()
        {
            @Override
            public Thread newThread(Runnable r)
            {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

    public static void main(String[] args)
    {
        AckFile ackFile = new AckFile();
        List<Integer> list = Arrays.asList(3, 5);
        List<CompletableFuture<Integer>> interFuture = list.stream()
            .map(ele -> CompletableFuture.supplyAsync(() -> ackFile.processInteger(ele)))
            .collect(Collectors.toList());
        List<Integer> list1 = interFuture.stream().map(CompletableFuture :: join).collect(Collectors.toList());
       list1.stream().forEach(System.out::println);
    }

}
