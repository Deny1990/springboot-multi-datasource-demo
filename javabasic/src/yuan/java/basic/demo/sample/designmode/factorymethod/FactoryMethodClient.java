package yuan.java.basic.demo.sample.designmode.factorymethod;

/**
 * Created by yuanxin on 17/11/14.
 */
public class FactoryMethodClient
{
    public static void main(String[] args)
    {
        ProductAFactory productAFactory = new ProductAFactory();
        Product product = productAFactory.createProduct();

    }
}
