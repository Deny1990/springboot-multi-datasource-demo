package yuan.java.basic.demo.sample.designmode.factorymethod;

/**
 * Created by yuanxin on 17/11/14.
 */
public class CreateProductA implements CreateProductInterface
{
    @Override
    public Product createProduct()
    {
        return new Product();
    }
}
