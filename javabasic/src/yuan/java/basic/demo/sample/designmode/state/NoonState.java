package yuan.java.basic.demo.sample.designmode.state;

/**
 * Created by yuanxin on 17/11/17.
 */
public class NoonState extends State
{
    @Override
    public void writeProgram(Work w)
    {
        if (w.getHour() < 13)
        {
            System.out.println("当前时间" + w.getHour());
        }
        else
        {
            w.setCurrent(new AfternoonState());
            w.writeProgram();
        }
    }
}
