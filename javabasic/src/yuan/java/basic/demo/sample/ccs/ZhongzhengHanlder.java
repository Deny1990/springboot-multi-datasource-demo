package yuan.java.basic.demo.sample.ccs;

/**
 * Created by yuanxin on 17/6/25.
 */
public class ZhongzhengHanlder extends BaseHandler
{
    @Override
    protected String handler(String taCode)
        throws Exception
    {
        if (taCode.equals("05"))
        {
            System.out.println("taCode  = 05 CurrentThread is "+Thread.currentThread());
            Thread.sleep(10000l);
            return "taCode = 05 ,0000";
        }
        else
        {
            System.out.println("CurrentThread is "+Thread.currentThread());
            throw new Exception("taCode error");
        }
    }
}
