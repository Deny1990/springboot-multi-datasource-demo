package yuan.java.basic.demo.sample.jdk8.streams;

/**
 * Created by yuanxin on 17/6/1.
 */
public class Transaction
{
    private  Trader trader;
    private  int year;
    private  int value;

    public Transaction(Trader trader, int year, int value)
    {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader()
    {
        return trader;
    }

    public void setTrader(Trader trader)
    {
        this.trader = trader;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("Transaction{");
        sb.append("trader=").append(trader);
        sb.append(", year=").append(year);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
