package yuan.java.basic.demo.sample.designmode.factory;

/**
 * 简单工厂模式
 * Created by yuanxin on 17/11/8.
 */
public class OperationFactory
{
    public static Operation createOperation(String operate)
    {
        Operation operation = null;
        switch (operate)
        {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
        }
        return operation;
    }
}
