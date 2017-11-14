package yuan.java.basic.demo.sample.designmode.factorymethod;

/**
 * Created by yuanxin on 17/11/14.
 */
public class ProductBFactory implements Creator
{
    @Override
    public Product createProduct()
    {
        return new CreateProductB().createProduct();
    }
}
