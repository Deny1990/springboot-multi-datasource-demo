package yuan.java.basic.demo.sample.designmode.decorator;

/**
 * Created by yuanxin on 17/11/9.
 */
public class ConcreteDecoratorA extends Decorator
{
    private String addState;

    @Override
    public void operation()
    {
        super.operation();
        addState = "new state";
        System.out.println("具体装饰对象A的操作");
    }
}
