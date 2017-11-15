package yuan.java.basic.demo.sample.designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanxin on 17/11/15.
 */
public abstract class Subject
{
    private List<Observer> observerList = new ArrayList<>();

    public void attach(Observer observer)
    {
        observerList.add(observer);
    }

    public void detach(Observer observer)
    {
        observerList.remove(observer);
    }

    public void notifyObserver()
    {
        observerList.stream().forEach(Observer::update);
    }
}
