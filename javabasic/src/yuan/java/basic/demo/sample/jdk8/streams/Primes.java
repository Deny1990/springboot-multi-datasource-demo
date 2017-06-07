package yuan.java.basic.demo.sample.jdk8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by yuanxin on 17/6/7.
 */
public class Primes
{
    public Map<Boolean, List<Integer>> partitionPrimes(int n)
    {
        return IntStream.rangeClosed(2, n).boxed()
            .collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
    }

    public boolean isPrime(int candidate)
    {
        int candidateRoot = (int)Math.sqrt((double)candidate);
        return IntStream.rangeClosed(2, candidateRoot)
            .noneMatch(i -> candidate % i == 0);
    }
}
