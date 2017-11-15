package yuan.java.basic.demo.sample.designmode.builder;

/**
 * 指挥者,根据用户需求构建对象
 * Created by yuanxin on 17/11/15.
 */
public class Director
{
    public void construct(Builder builder)
    {
        builder.builderPartA();
        builder.builderPartB();
    }
}
