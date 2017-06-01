package yuan.java.basic.demo.sample.jdk8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by yuanxin on 17/5/31.
 */
public class StreamOperation
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

    private void fiterByVegetarian()
    {
        menu.stream()
            .filter(Dish::isVegetarian)
            .collect(toList());
    }

    private void distinctTest()
    {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
    }

    private void testSkip()
    {
        List<Dish> list = menu.stream().filter(d -> d.getCalories() > 300).skip(2).skip(2).collect(toList());
        list.stream().forEach(System.out::println);
    }

    private void testMap()
    {
        List<String> words = Arrays.asList("Java8", "Lambads", "In", "Action");
        List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
        wordLengths.stream().forEach(System.out::println);
    }

    private void testFlatMap()
    {
        List<String> words = Arrays.asList("Java8", "Lambads", "In", "Action");
        List<Stream<String>> streamList = words.stream()
            .map(word -> word.split(""))
            .map(Arrays::stream)
            .distinct()
            .collect(toList());

        List<String> list = words.stream()
            .map(word -> word.split(""))
            .flatMap(Arrays::stream)
            .distinct()
            .collect(toList());

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(n -> n * n).collect(Collectors.toList());
    }

    private void pairs()
    {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs =
            numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[] {i, j})).collect(Collectors.toList());
    }

    private void testFind()
    {
        if (menu.stream().anyMatch(Dish::isVegetarian))
        {
            System.out.println("The menu is (somewhat) vegetarian friendly!");
        }
    }

    private void testFindAll()
    {
        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 100);
    }

    private void testFindAny()
    {
        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
    }

    private void testFindFirst()
    {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
            someNumbers.stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst();

    }

}
