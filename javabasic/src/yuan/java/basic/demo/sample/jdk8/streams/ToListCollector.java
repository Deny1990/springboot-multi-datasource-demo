package yuan.java.basic.demo.sample.jdk8.streams;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by yuanxin on 17/6/7.
 */
public class ToListCollector<T> implements Collector<T,List<T>,List<T>>
{
    @Override
    public Supplier<List<T>> supplier()
    {
        return () ->new ArrayList<T>();
    }

    @Override
    public BiConsumer<List<T>, T> accumulator()
    {
        return (list,item)->list.add(item);
    }

    @Override
    public BinaryOperator<List<T>> combiner()
    {
        return (list1,list2)->{
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher()
    {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics()
    {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH,Characteristics.CONCURRENT));
    }
}
