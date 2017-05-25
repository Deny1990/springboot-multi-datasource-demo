package yuan.java.basic.demo.sample.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by yuanxin on 17/5/25.
 */
public class PredicateDemo
{
    public static <T> List<T> filter(List<T> list, Predicate<T> p)
    {
        List<T> results = new ArrayList<>();
        for (T s : list
            )
        {
            if (p.test(s))
            {
                results.add(s);
            }
        }
        return results;
    }

    public static void main(String[] args)
    {
        List<String> listOfStrings = Arrays.asList("hello", "world");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        nonEmpty.stream().forEach(System.out::println);
    }
}
