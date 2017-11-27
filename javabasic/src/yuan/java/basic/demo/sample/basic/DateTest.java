package yuan.java.basic.demo.sample.basic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuanxin on 17/11/27.
 */
public class DateTest
{
    public static void main(String[] args)
    {
        Date createDate = new Date();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(df.format(createDate));
        DateFormat tf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(tf.format(createDate));
    }
}
