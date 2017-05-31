package yuan.java.basic.demo.sample.jdk8.lambda;

import java.math.BigDecimal;

/**
 * Created by yuanxin on 17/5/26.
 */
public class MyBean
{
    BigDecimal debit;

    BigDecimal fee;

    public MyBean()
    {
        this.debit = BigDecimal.ZERO;
        this.fee = BigDecimal.ZERO;
    }

    public BigDecimal getDebit()
    {
        return debit;
    }

    public void setDebit(BigDecimal debit)
    {
        this.debit = debit;
    }

    public BigDecimal getFee()
    {
        return fee;
    }

    public void setFee(BigDecimal fee)
    {
        this.fee = fee;
    }
}
