package yuan.java.basic.demo.sample.agency.dynproxy;

/**
 * Created by yuanxin on 17/5/11.
 */
public class RealSubject implements Subject
{
    @Override
    public void dealTask(String taskName)
    {
        System.out.println("正在执行任务："+taskName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void dealTaskTwo(String taskName)
    {
        System.out.println("正在执行subjectTwo任务："+taskName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
