package yuan.java.basic.demo.sample.designmode.facade;

/**
 * 外观模式: 为子系统中的一组接口提供一个一致的界面,
 * 此模式定义了一个高层接口,这个接口使得这一子系统更加容易使用.
 * Created by yuanxin on 17/11/14.
 */
public class Facade
{
    SubSystemOne subSystemOne;

    SubSystemTwo subSystemTwo;

    SubSystemThree subSystemThree;

    public Facade()
    {
        this.subSystemOne = new SubSystemOne();
        this.subSystemTwo = new SubSystemTwo();
        this.subSystemThree = new SubSystemThree();
    }

    public void methodA()
    {
        System.out.println("方法组A");
        subSystemOne.methodOne();
        subSystemThree.methodThree();
    }

    public void methodB()
    {
        System.out.println("方法组B");
        subSystemTwo.methodTwo();
    }
}
