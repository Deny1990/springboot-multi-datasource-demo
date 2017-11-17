package yuan.java.basic.demo.sample.designmode.state;

/**
 * Created by yuanxin on 17/11/17.
 */
public class StateClient
{
    public static void main(String[] args)
    {
        Work work = new Work();
        work.setHour(16);
        work.writeProgram();
    }
}
