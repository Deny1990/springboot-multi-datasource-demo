package yuan.java.basic.demo.sample.jdk8.parallelstream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by yuanxin on 17/6/8.
 */
public class SpliterWords
{
    final static String SENTENC = "Nel mezzo del cammin di nostra viami ritrovai in una selva";

    public static int countWordsIteratively(String s)
    {
        int count = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray())
        {
            if (Character.isWhitespace(c))
            {
                lastSpace = true;
            }
            else
            {
                if (lastSpace)
                {
                    count++;
                }
                lastSpace = false;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Stream<Character> stream = IntStream.range(0, SENTENC.length())
            .mapToObj(i -> SENTENC.charAt(i));
        int count = countWordsIteratively(SENTENC);
        System.out.println(count);
    }

}
