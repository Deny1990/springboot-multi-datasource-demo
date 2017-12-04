package yuan.java.basic.demo.sample.basic;

/**
 * Created by yuanxin on 17/11/28.
 */
public class StringTest
{
    public static void main(String[] args)
    {
        String aa  = "93#00001";
        String[] bb = aa.split("#");
        System.out.printf(bb[1]);
    }
}
