package yuan.java.basic.demo.sample.designmode.builder;

/**
 * Created by yuanxin on 17/11/15.
 */
public class ConcreteBuilderTwo extends Builder
{
    private Product product = new Product();

    @Override
    void builderPartA()
    {
        product.add("部件x");
    }

    @Override
    void builderPartB()
    {
        product.add("部件Y");
    }

    @Override
    Product getProduct()
    {
        return product;
    }
}
