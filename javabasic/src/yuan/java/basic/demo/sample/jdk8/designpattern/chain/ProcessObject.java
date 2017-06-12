package yuan.java.basic.demo.sample.jdk8.designpattern.chain;

/**
 * Created by yuanxin on 17/6/12.
 */
public abstract class ProcessObject<T>
{
    protected ProcessObject<T> successor;

    public void setSuccessor(ProcessObject<T> successor)
    {
        this.successor = successor;
    }

    public T handle(T input)
    {
        T r = handleWork(input);

        if (successor != null)
        {
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);

}
