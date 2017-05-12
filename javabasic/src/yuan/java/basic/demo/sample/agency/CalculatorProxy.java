package yuan.java.basic.demo.sample.agency;

/**
 * Created by yuanxin on 17/5/11.
 */
public class CalculatorProxy implements Calculator
{
    private Calculator calculator;
    CalculatorProxy(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public int add(int a, int b)
    {
        int result= calculator.add(a,b);
        return result;
    }
}
