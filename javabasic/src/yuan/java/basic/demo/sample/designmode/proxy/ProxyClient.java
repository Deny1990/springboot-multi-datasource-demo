package yuan.java.basic.demo.sample.designmode.proxy;

/**
 * Created by yuanxin on 17/11/14.
 */
public class ProxyClient
{
    public static void main(String[] args)
    {
        SchoolGirl girl = new SchoolGirl();
        girl.setName("yan");
        Proxy proxy = new Proxy(girl);
        proxy.giveDolls();
        proxy.giveFlowers();

    }
}
