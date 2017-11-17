package yuan.java.basic.demo.sample.designmode.state;

/**
 * Created by yuanxin on 17/11/17.
 */
public class AfternoonState extends State
{
    @Override
    public void writeProgram(Work w)
    {
        if (w.getHour()<17)
        {
            System.out.println("当前时间"+w.getHour());
        }
    }
}
