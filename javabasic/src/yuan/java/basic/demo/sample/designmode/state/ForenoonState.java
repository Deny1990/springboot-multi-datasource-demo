package yuan.java.basic.demo.sample.designmode.state;

/**
 * Created by yuanxin on 17/11/17.
 */
public class ForenoonState extends State
{
    @Override
    public void writeProgram(Work w)
    {
        if (w.getHour() < 12)
        {
            System.out.println("当前时间" + w.getHour());
        }
        else
        {
            w.setCurrent(new NoonState());
            w.writeProgram();
        }

    }
}
