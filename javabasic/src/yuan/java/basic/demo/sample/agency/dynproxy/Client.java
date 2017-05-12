package yuan.java.basic.demo.sample.agency.dynproxy;

/**
 * Created by yuanxin on 17/5/11.
 */
public class Client
{
    public static void main(String[] args)
    {
        Subject proxy = DynProxyFactory.getInstance();
        proxy.dealTask("hello");
        proxy.dealTaskTwo("world");
    }
}
