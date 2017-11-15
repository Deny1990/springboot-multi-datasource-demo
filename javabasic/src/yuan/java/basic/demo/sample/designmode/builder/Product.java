package yuan.java.basic.demo.sample.designmode.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanxin on 17/11/15.
 */
public class Product
{
    List<String> parts = new ArrayList<>();

    public void add(String part)
    {
        parts.add(part);
    }

    public void show()
    {
        System.out.println("产品创建");
        parts.stream().forEach(System.out::println);

    }
}
