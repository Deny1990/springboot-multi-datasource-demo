package yuan.java.basic.demo.sample.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by yuanxin on 17/5/25.
 */
public class FunctionDemo
{
    public  static <T,R> List<R> map(List<T> list ,Function<T,R> f){
        List<R> result = new ArrayList<>();
        for (T t: list
             )
        {
            result.add(f.apply(t));
        }
        return result;
    }

    public static void main(String[] args)
    {
        List<Integer> integerList = map(Arrays.asList("hello","worlddd","womenn"),(String s) -> s.length());
        integerList.stream().forEach(System.out::println);
    }
}
