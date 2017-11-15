package yuan.java.basic.demo.sample.designmode.builder;

/**
 * Created by yuanxin on 17/11/15.
 */
public class ConcreteBuilderOne extends Builder
{
    private Product product = new Product();

    @Override
    void builderPartA()
    {
        product.add("PartA");
    }

    @Override
    void builderPartB()
    {
        product.add("PartB");
    }

    @Override
    Product getProduct()
    {
        return product;
    }
}
