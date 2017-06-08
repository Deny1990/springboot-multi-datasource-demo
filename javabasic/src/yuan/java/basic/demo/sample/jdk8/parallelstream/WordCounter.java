package yuan.java.basic.demo.sample.jdk8.parallelstream;

import java.util.stream.Stream;

/**
 * Created by yuanxin on 17/6/8.
 */
public class WordCounter
{
    private int counter;

    private boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace)
    {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter accmmulate(Character c)
    {
        if (Character.isWhitespace(c))
        {
            if (lastSpace)
            {
                //上个是空格,当前也是空格
                return this;
            }
            else
            {
                //上一个不是空格,当前是空格
                return new WordCounter(counter, true);
            }
        }
        else
        {
            if (lastSpace)
            {
                //上一个是空格,当前不是空格
                return new WordCounter(counter + 1, false);
            }
            else
            {
                //上一个不是空格,当前也不是空格
                return this;
            }
        }
    }

    public WordCounter combine(WordCounter wordCounter)
    {
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter()
    {
        return counter;
    }

    public static int countWords(Stream<Character> stream)
    {
        WordCounter wordCounter =
            stream.reduce(new WordCounter(0, true),
                (WordCounter wordCounter1,Character c) ->{
                    return wordCounter1.accmmulate(c);
                },
                (WordCounter wordCounter2,WordCounter wordCounter3)->{
                    return wordCounter2.combine(wordCounter3);
                });
        return wordCounter.getCounter();
    }
}
