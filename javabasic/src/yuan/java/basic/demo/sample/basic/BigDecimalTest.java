package yuan.java.basic.demo.sample.basic;

import java.math.BigDecimal;

/**
 * Created by yuanxin on 17/9/18.
 */
public class BigDecimalTest
{
    public static void main(String[] args)
    {
        BigDecimal bigDecimal = new BigDecimal("2570061");
        BigDecimal divBigDecimal = bigDecimal.divide(BigDecimal.valueOf(100),2,BigDecimal.ROUND_DOWN);
        System.out.println(divBigDecimal);

    }
}
