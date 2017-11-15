package yuan.java.basic.demo.sample.designmode.observer;

/**
 * Created by yuanxin on 17/11/15.
 */
public class ObserverClient
{
    public static void main(String[] args)
    {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observerOne = new ConcreteObserver("hello",subject);
        Observer observerTwo = new ConcreteObserver("world",subject);

        subject.attach(observerOne);
        subject.attach(observerTwo);

        subject.setSubjectState("china");

        subject.notifyObserver();

    }
}
