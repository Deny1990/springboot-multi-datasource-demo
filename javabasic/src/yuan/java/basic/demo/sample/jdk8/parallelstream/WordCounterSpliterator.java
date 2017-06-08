package yuan.java.basic.demo.sample.jdk8.parallelstream;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by yuanxin on 17/6/8.
 */
public class WordCounterSpliterator implements Spliterator<Character>
{
    final static String SENTENC = "abcd yuan meng xiang";
    private String string;

    private int currentChar = 0;

    public WordCounterSpliterator(String string)
    {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action)
    {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit()
    {
        int currentSize = string.length() - currentChar;
        if (currentSize < 5)
        {
            return null;
        }
        for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++)
        {
            char c =  string.charAt(splitPos);
            if (Character.isWhitespace(string.charAt(splitPos)))
            {
                Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar,splitPos));
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize()
    {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics()
    {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }

    public static void main(String[] args)
    {
        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENC);
        Stream<Character> stream =  StreamSupport.stream(spliterator,true);
        System.out.println("Found "+WordCounter.countWords(stream)+" words");
    }
}
