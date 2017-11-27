package yuan.java.basic.demo.sample.basic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yuanxin on 17/11/21.
 */
public class ListTest
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("hello","world");
        String he = list.get(0);
        System.out.println(he);
    }
}
