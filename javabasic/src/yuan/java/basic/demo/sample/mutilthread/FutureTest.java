package yuan.java.basic.demo.sample.mutilthread;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * Created by yuanxin on 17/5/11.
 */
public class FutureTest
{
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4,10l, TimeUnit.SECONDS,new LinkedBlockingDeque<>(2));
    public  Future<HashMap> getDataFromRemote2(){
        return threadPoolExecutor.submit(new Callable<HashMap>()
        {
            @Override
            public HashMap call()
                throws Exception
            {
                return getDataFromRemote();
            }
        });
    }
    private HashMap getDataFromRemote(){
        return new HashMap();
    }

    public static void main(String[] args)
    {
        FutureTest futureTest = new FutureTest();
        futureTest.getDataFromRemote2();
    }
}
