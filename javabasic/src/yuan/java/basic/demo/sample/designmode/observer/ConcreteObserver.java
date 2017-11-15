package yuan.java.basic.demo.sample.designmode.observer;

/**
 * Created by yuanxin on 17/11/15.
 */
public class ConcreteObserver extends Observer
{
    private String name;

    private String observerState;

    private ConcreteSubject subject;

    public ConcreteObserver(String name, ConcreteSubject subject)
    {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update()
    {
        observerState = subject.getSubjectState();
        System.out.println("name "+name+"state :"+observerState);
    }

    public ConcreteSubject getSubject()
    {
        return subject;
    }

    public void setSubject(ConcreteSubject subject)
    {
        this.subject = subject;
    }
}
