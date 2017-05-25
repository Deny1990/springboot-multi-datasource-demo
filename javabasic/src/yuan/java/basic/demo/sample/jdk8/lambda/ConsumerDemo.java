package yuan.java.basic.demo.sample.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by yuanxin on 17/5/25.
 */
public class ConsumerDemo
{
    public static <T> void forEach(List<T> list, Consumer<T> c)
    {
        for (T i : list
            )
        {
            c.accept(i);
        }
    }

    public static void main(String[] args)
    {
      forEach(Arrays.asList(1,2,3,4,5),
          (Integer i) -> System.out.println(i));
    }
}
