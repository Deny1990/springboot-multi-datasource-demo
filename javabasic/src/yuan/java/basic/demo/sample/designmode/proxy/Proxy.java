package yuan.java.basic.demo.sample.designmode.proxy;

/**
 * Created by yuanxin on 17/11/14.
 */
public class Proxy implements GiveGift
{

    Pursuit pursuit;

    public Proxy(SchoolGirl girl)
    {
        this.pursuit = new Pursuit(girl);
    }

    @Override
    public void giveDolls()
    {
        pursuit.giveDolls();
    }

    @Override
    public void giveFlowers()
    {
        pursuit.giveFlowers();
    }
}
