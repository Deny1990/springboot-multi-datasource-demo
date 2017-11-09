package yuan.java.basic.demo.sample.designmode.strategy;

/**
 * Created by yuanxin on 17/11/9.
 */
public class Context
{
    Strategy strategy;

    public Context(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void contextInterface()
    {
        strategy.algorithmInterface();
    }
}
