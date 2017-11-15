package yuan.java.basic.demo.sample.designmode.observer;

/**
 * Created by yuanxin on 17/11/15.
 */
public class ConcreteSubject extends Subject
{
    private String subjectState;

    public String getSubjectState()
    {
        return subjectState;
    }

    public void setSubjectState(String subjectState)
    {
        this.subjectState = subjectState;
    }
}
