package yuan.java.basic.demo.sample.designmode.factory;

/**
 * Created by yuanxin on 17/11/8.
 */
public class OperationMul extends Operation
{
    public double getResult()
    {
        return this.getNumberA()*this.getNumberB();
    }
}
