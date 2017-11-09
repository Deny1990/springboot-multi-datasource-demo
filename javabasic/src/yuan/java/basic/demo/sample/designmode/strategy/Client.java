package yuan.java.basic.demo.sample.designmode.strategy;

/**
 * Created by yuanxin on 17/11/9.
 */
public class Client
{
    public static void main(String[] args)
    {
//        Context context;
//
//        context = new Context(new ConcreteStrategyA());
//        context.contextInterface();
//
//        context = new Context(new ConcreteStrategyB());
//        context.contextInterface();
//
//        context = new Context(new ConcreteStrategyC());
//        context.contextInterface();
        testStratey();
    }

    static void testStratey()
    {
        Context context = new Context("A");
        context.contextInterface();
    }
}
