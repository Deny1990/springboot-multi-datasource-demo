package yuan.java.basic.demo.sample.designmode.decorator;

/**
 * Created by yuanxin on 17/11/9.
 */
public class ConcreteDecoratorB extends Decorator
{
    @Override
    public void operation()
    {
        super.operation();
        addBehavior();
        System.out.println("具体装饰对象b的操作");
    }

    private void addBehavior()
    {
        System.out.println("ConcreteDecoratorB 特有方法");
    }
}
