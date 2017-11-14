package yuan.java.basic.demo.sample.designmode.template;

/**
 * Created by yuanxin on 17/11/14.
 */
public class ConcreteClassA extends AbstractClass
{
    @Override
    void operation1()
    {
        System.out.println("classA method");
    }

    @Override
    void operation2()
    {
        System.out.println("classB method");
    }
}
