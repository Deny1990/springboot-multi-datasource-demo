package yuan.java.basic.demo.sample.jdk8.parallelstream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Created by yuanxin on 17/6/7.
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long>
{
    private long[] numbers;

    private int start;

    private int end;

    public static final long THRESHOLD = 10;

    public ForkJoinSumCalculator(long[] numbers)
    {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end)
    {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute()
    {
        int length = end - start;
        if (length <= THRESHOLD)
        {
            return computeSequentially();
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length/2);
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length/2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private long computeSequentially()
    {
        long sum = 0;
        for (int i = start; i < end; i++)
        {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n)
    {
       long[] numbers = LongStream.rangeClosed(1,n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args)
    {
        long n = forkJoinSum(200);
        System.out.println(n);
    }
}
