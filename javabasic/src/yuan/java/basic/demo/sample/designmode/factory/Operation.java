package yuan.java.basic.demo.sample.designmode.factory;

/**
 * Created by yuanxin on 17/11/8.
 */
public class Operation
{
    private double numberA;

    private double numberB;

    public double getNumberA()
    {
        return numberA;
    }

    public void setNumberA(double numberA)
    {
        this.numberA = numberA;
    }

    public double getNumberB()
    {
        return numberB;
    }

    public void setNumberB(double numberB)
    {
        this.numberB = numberB;
    }

    public double getResult() throws Exception
    {
        return 0;
    }
}
