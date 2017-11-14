package yuan.java.basic.demo.sample.designmode.factorymethod;

/**
 * Created by yuanxin on 17/11/14.
 */
public class ProductAFactory implements Creator
{
    @Override
    public Product createProduct()
    {
        return new CreateProductA().createProduct();
    }
}
