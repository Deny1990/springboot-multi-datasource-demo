package yuan.java.basic.demo.sample.jdk8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by yuanxin on 17/6/1.
 */
public class TranstionOperation
{
    static Trader raoul = new Trader("Raoul", "Cambridge");

    static Trader mario = new Trader("Mario", "Milan");

    static Trader alan = new Trader("Alan", "Cambridge");

    static Trader brian = new Trader("Brian", "Cambridge");

    static List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    static List<Dish> menu = Arrays.asList(new Dish("pork", false, 1000, Type.MEAT),
        new Dish("beef", false, 700, Type.MEAT),
        new Dish("chicken", false, 400, Type.MEAT),
        new Dish("french fries", true, 530, Type.OTHER),
        new Dish("rice", true, 350, Type.OTHER),
        new Dish("season fruit", true, 120, Type.OTHER),
        new Dish("pizza", true, 500, Type.OTHER),
        new Dish("prawns", false, 300, Type.FISH),
        new Dish("salmon", false, 450, Type.FISH)
    );

    private void findSortedValueByYear()
    {
        transactions.stream()
            .filter(trans -> trans.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getValue))
            .collect(toList());
    }

    private void findDifferentCity()
    {
        transactions.stream()
            .map(trans -> trans.getTrader())
            .map(trader -> trader.getCity())
            .distinct()
            .collect(toList());
    }

    private void findJianqiaoTrader()
    {
        transactions.stream().map(transaction -> transaction.getTrader())
            .filter(trader -> trader.getCity().equals("Cambridge"))
            .distinct()
            .sorted(Comparator.comparing(Trader::getName))
            .collect(toList());
    }

    private void test()
    {
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
            .flatMap(a -> IntStream.rangeClosed(a, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[] {a, b, (int)Math.sqrt(a * a + b * b)})
            );

    }

    private void geneaterFibonacci()
    {
        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
            .limit(10)
            .map(t -> t[0])
            .forEach(System.out::println);
    }

    private static void testJoining()
    {
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        String shortMenuTwo = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenuTwo);
    }

    public static void main(String[] args)
    {
        testJoining();
    }
}
