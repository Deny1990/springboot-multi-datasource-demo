package yuan.java.basic.demo.sample.jdk8.parallelstream;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by yuanxin on 17/6/8.
 */
public class WordCounterSpliterator implements Spliterator<Character>
{
    @Override
    public boolean tryAdvance(Consumer<? super Character> action)
    {
        return false;
    }

    @Override
    public Spliterator<Character> trySplit()
    {
        return null;
    }

    @Override
    public long estimateSize()
    {
        return 0;
    }

    @Override
    public int characteristics()
    {
        return 0;
    }
}
