package yuan.java.basic.demo.sample.jdk8.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanxin on 17/5/26.
 */
public class methodreference
{
    public static void main(String[] args)
    {
        MyBean beanone = new MyBean();
        beanone.setDebit(BigDecimal.ONE);
        beanone.setFee(BigDecimal.ONE);

        MyBean beantwo = new MyBean();
        beantwo.setDebit(BigDecimal.TEN);
        beantwo.setFee(BigDecimal.ONE);

        List<MyBean> beans = new ArrayList<>();
        beans.add(beanone);
        beans.add(beantwo);

        MyBean ininal = new MyBean();
        MyBean sum = beans.stream().reduce(ininal, (a, b) -> {
            MyBean mybean = new MyBean();
            mybean.setDebit(a.getDebit().add(b.getDebit()));
            mybean.setFee(a.getFee().add(b.getFee()));
            return mybean;
        });
        System.out.println(sum.getDebit());
        System.out.println(sum.getFee());

    }
}
