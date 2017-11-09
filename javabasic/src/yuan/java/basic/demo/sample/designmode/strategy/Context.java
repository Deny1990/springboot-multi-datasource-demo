package yuan.java.basic.demo.sample.designmode.strategy;

/**
 * 策略模式
 * Created by yuanxin on 17/11/9.
 */
public class Context
{
    Strategy strategy;

    public Context(String type)
    {
        switch (type)
        {
            case "A":
                strategy = new ConcreteStrategyA();
                break;

            case "B":
                strategy = new ConcreteStrategyB();
                break;

            case "C":
                strategy = new ConcreteStrategyC();
                break;
        }
    }

    public Context(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void contextInterface()
    {
        strategy.algorithmInterface();
    }
}
