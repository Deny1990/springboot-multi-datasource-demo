package yuan.java.basic.demo.sample.jdk8.completablefuture;

import static yuan.java.basic.demo.sample.jdk8.completablefuture.Util.delay;
import static yuan.java.basic.demo.sample.jdk8.completablefuture.Util.format;

/**
 * Created by yuanxin on 17/6/15.
 */
public class Discount
{
    public enum Code
    {
        NONE(0), SLIVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private int percentage;

        Code(int percentage)
        {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote)
    {
        System.out.println("applyDisCount thread is "+Thread.currentThread());
        return quote.getShopName() + "price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    private static double apply(double price, Code code)
    {
        delay();
       return format(price*(100 - code.percentage)/100);
    }



}
