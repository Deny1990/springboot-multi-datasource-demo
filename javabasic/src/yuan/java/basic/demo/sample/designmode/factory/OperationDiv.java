package yuan.java.basic.demo.sample.designmode.factory;

/**
 * Created by yuanxin on 17/11/8.
 */
public class OperationDiv extends Operation
{
    public double getResult() throws Exception
    {
        if (this.getNumberB() == 0)
        {
            throw  new Exception();
        }
        return this.getNumberA() / this.getNumberB();
    }
}
