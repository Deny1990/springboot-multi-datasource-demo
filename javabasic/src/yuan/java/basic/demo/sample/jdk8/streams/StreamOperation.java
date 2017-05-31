package yuan.java.basic.demo.sample.jdk8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by yuanxin on 17/5/31.
 */
public class StreamOperation {
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

    private void fiterByVegetarian() {
        menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
    }

    private void distinctTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
    }

    private void testSkip() {
        List<Dish> list = menu.stream().filter(d -> d.getCalories() > 300).skip(2).skip(2).collect(toList());
        list.stream().forEach(System.out::println);
    }

    private void testMap() {
        List<String> words = Arrays.asList("Java8", "Lambads", "In", "Action");
        List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
        wordLengths.stream().forEach(System.out::println);
    }

    private void testFlatMap() {
        List<String> words = Arrays.asList("Java8", "Lambads", "In", "Action");
        List<Stream<String>> streamList = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());


    }


}
