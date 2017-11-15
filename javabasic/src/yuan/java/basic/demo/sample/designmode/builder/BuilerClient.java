package yuan.java.basic.demo.sample.designmode.builder;

/**
 * 建造者模式:
 * 将一个复杂对象的构建与他的表示分离,使得同样的构建过程可以创建不同的表示
 * Created by yuanxin on 17/11/15.
 */
public class BuilerClient
{
    public static void main(String[] args)
    {
        Director director = new Director();
        Builder bOne  = new ConcreteBuilderOne();
        Builder bTwo = new ConcreteBuilderTwo();

        director.construct(bOne);
        Product p1 = bOne.getProduct();
        p1.show();


        director.construct(bTwo);
        Product p2 = bTwo.getProduct();
        p2.show();
    }
}
