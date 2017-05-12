package yuan.java.basic.demo.sample.agency.dynproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yuanxin on 17/5/11.
 */
public class SubjectInvocationHandler implements InvocationHandler
{
    private Object delegate;

    public SubjectInvocationHandler(Object delegate){
        this.delegate = delegate;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable
    {
        long stime = System.currentTimeMillis();
        method.invoke(delegate,args);
        long ftime = System.currentTimeMillis();
        System.out.println("执行任务耗时"+(ftime - stime)+"毫秒");
        return null;
    }
}
