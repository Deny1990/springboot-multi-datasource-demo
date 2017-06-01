package yuan.java.basic.demo.sample.jdk8.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yuanxin on 17/6/1.
 */
public class CollectionOperation
{

    private static List<Dish> menu = Arrays.asList(new Dish("pork", false, 1000, Type.MEAT),
        new Dish("beef", false, 700, Type.MEAT),
        new Dish("chicken", false, 400, Type.MEAT),
        new Dish("french fries", true, 530, Type.OTHER),
        new Dish("rice", true, 350, Type.OTHER),
        new Dish("season fruit", true, 120, Type.OTHER),
        new Dish("pizza", true, 500, Type.OTHER),
        new Dish("prawns", false, 300, Type.FISH),
        new Dish("salmon", false, 450, Type.FISH)
    );

    private void testSum(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.stream().reduce(1,Integer ::sum);
    }

}
