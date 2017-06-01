package yuan.java.basic.demo.sample.jdk8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    private void findSortedValueByYear()
    {
        transactions.stream()
            .filter(trans -> trans.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getValue))
            .collect(Collectors.toList());
    }

    private void findDifferentCity()
    {
        transactions.stream()
            .map(trans -> trans.getTrader())
            .map(trader -> trader.getCity())
            .distinct()
            .collect(Collectors.toList());
    }

    private void findJianqiaoTrader()
    {
        transactions.stream().map(transaction -> transaction.getTrader())
            .filter(trader -> trader.getCity().equals("Cambridge"))
            .distinct()
            .sorted(Comparator.comparing(Trader::getName))
            .collect(Collectors.toList());
    }

    private void test(){
        Stream<int[]>  pythagoreanTriples = IntStream.rangeClosed(1,100).boxed()
            .flatMap(a -> IntStream.rangeClosed(a,100)
                     .filter(b -> Math.sqrt(a*a + b*b) % 1 ==0)
                     .mapToObj(b -> new int[]{a,b,(int)Math.sqrt(a*a + b*b)})
            );

    }
}
