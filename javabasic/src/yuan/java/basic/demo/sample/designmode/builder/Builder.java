package yuan.java.basic.demo.sample.designmode.builder;

/**
 * 定义构建对象必须的步骤,即构造和装配各个部件
 * Created by yuanxin on 17/11/15.
 */
public abstract class Builder
{
    abstract void builderPartA();

    abstract void builderPartB();

    abstract  Product getProduct();
}
