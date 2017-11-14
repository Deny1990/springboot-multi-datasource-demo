package yuan.java.basic.demo.sample.designmode.facade;

/**
 * Created by yuanxin on 17/11/14.
 */
public class FacadeClient
{
    public static void main(String[] args)
    {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}
