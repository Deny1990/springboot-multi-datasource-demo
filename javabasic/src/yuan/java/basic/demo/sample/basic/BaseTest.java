package yuan.java.basic.demo.sample.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanxin on 17/12/27.
 */
public class BaseTest
{
    private List list = new ArrayList();

    public BaseTest(){
        list.add("1");
    }

    public List getList()
    {
        return list;
    }

    public static void main(String[] args)
    {
        BaseTest test = new BaseTest();
        List aList = test.getList();
        aList.add("333");

        List bList = test.getList();

        bList.stream().forEach(System.out::println);

    }
}
