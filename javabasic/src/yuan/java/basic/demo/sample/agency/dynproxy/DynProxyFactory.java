package yuan.java.basic.demo.sample.agency.dynproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by yuanxin on 17/5/11.
 */
public class DynProxyFactory
{
    public static Subject  getInstance()
    {
        Subject delegate = new RealSubject();
        InvocationHandler handler = new SubjectInvocationHandler(delegate);
        Subject proxy = null;
        proxy = (Subject)Proxy.newProxyInstance(delegate.getClass().getClassLoader(),delegate.getClass().getInterfaces(),
            handler);
        return proxy;
    }
}
