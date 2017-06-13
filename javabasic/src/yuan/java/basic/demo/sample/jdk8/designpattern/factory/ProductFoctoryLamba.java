package yuan.java.basic.demo.sample.jdk8.designpattern.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by yuanxin on 17/6/12.
 */
public class ProductFoctoryLamba
{
    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static
    {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct(String name)
    {
        Supplier<Product> p = map.get(name);
        if (p != null)
            return p.get();
        throw new IllegalArgumentException("No such product" + name);
    }
}