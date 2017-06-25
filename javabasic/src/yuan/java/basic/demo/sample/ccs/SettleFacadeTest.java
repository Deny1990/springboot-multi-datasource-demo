package yuan.java.basic.demo.sample.ccs;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yuanxin on 17/6/25.
 */
public class SettleFacadeTest
{
    static Map<String, BaseHandler> map = new HashMap<>();

    static
    {

        map.put("05", new ZhongzhengHanlder());
        map.put("12", new BoseraHandler());
    }

    private final static Executor executor =
        Executors.newFixedThreadPool(Math.min(2, 10), new ThreadFactory()
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
        Result result = settleHandler();
        System.out.println(result);
    }

    private static Result settleHandler()
    {
        List<String> taCodeList = Arrays.asList("12","05");
        Stream<CompletableFuture<String>> completableFutureStream = taCodeList.stream()
            .map(taCode -> CompletableFuture.supplyAsync(() -> settleAccountHandler(taCode), executor));
        List<String> reList = completableFutureStream.map(CompletableFuture::join).collect(Collectors.toList());
        Optional<String> stringOptional = reList.stream().filter(reString -> !reString.equals("0000")).findAny();
        Result result = new Result();
        if (stringOptional.isPresent())
        {
            result.setResultCode("11100");
        }
        else
        {
            result.setResultCode("0000");
        }
        result.setResultMsg(reList.stream().collect(Collectors.joining(", ")));
        return result;
    }

    private static String settleAccountHandler(String taCode)
    {
        try
        {
            return map.get(taCode).handler(taCode);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
