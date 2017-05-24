package yuan.java.basic.demo.sample.jdk8.parameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuanxin on 17/5/24.
 */
public class FilterApples
{
    public static void main(String[] args)
    {
        List<Apple> inventory = Arrays.asList(new Apple("red", 10l), new Apple("green", 200l));
        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p)
    {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory)
        {
            if (p.test(apple))
            {
                result.add(apple);
            }
        }
        return result;

    }
}
