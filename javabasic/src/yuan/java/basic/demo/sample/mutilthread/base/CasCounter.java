package yuan.java.basic.demo.sample.mutilthread.base;

/**
 * Created by yuanxin on 17/7/28.
 */
public class CasCounter
{
    private SimulatedCAS value;

    public int getValue()
    {
        return value.get();
    }

    public int increment()
    {
        int v;
        do
        {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }
}
