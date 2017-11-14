package yuan.java.basic.demo.sample.designmode.template;

/**
 * Created by yuanxin on 17/11/14.
 */
public abstract class AbstractClass
{
    abstract void operation1();

    abstract void operation2();

    public void templateMethod()
    {
        operation1();
        operation2();
    }
}
