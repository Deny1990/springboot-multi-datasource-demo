package yuan.java.basic.demo.sample.designmode.decorator;

/**
 * 装饰器模式
 * Created by yuanxin on 17/11/9.
 */
public class Client
{
    public static void main(String[] args)
    {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();
        concreteDecoratorA.setComponent(concreteComponent);
        concreteDecoratorB.setComponent(concreteDecoratorA);
        concreteDecoratorB.operation();
    }
}
