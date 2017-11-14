package yuan.java.basic.demo.sample.designmode.proxy;

/**
 * Created by yuanxin on 17/11/14.
 */
public class Pursuit implements  GiveGift
{
    SchoolGirl schoolGirl;

    public Pursuit(SchoolGirl schoolGirl)
    {
        this.schoolGirl = schoolGirl;
    }

    @Override
    public void giveDolls()
    {
        System.out.println("送玩具");
    }

    @Override
    public void giveFlowers()
    {
        System.out.println("送花");
    }
}
