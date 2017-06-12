package yuan.java.basic.demo.sample.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yuanxin on 17/6/12.
 */
public class DebugTest
{
    public static void main(String[] args)
    {
        test1();
    }

    static void test()
    {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        numbers.stream()
            .map(x -> {
                System.out.println(x);
                return x + 17;
            })
            .filter(x -> {
                System.out.println(x);
                return x % 2 == 0;
            })
            .limit(3).forEach(System.out::println);
    }

    static void test1()
    {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        List<Integer> result = numbers.stream()
            .peek(x -> System.out.println("from stream x is " + x))
            .map(x -> x + 17)
            .peek(x -> System.out.println("after map  x is " + x))
            .filter(x -> x % 2 == 0)
            .peek(x -> System.out.println("after filter  x is " + x))
            .limit(3)
            .peek(x -> System.out.println("after limit  x is " + x))
            .collect(Collectors.toList());
        result.stream().forEach(System.out::println);
    }
}
