package yuan.java.basic.demo.sample.ccs;

/**
 * Created by yuanxin on 17/6/25.
 */
public class BoseraHandler extends BaseHandler
{

    @Override
    protected String handler(String taCode)
        throws Exception
    {
        if (taCode.equals("11"))
        {
            System.out.println("CurrentThread is "+Thread.currentThread());
            return "0000";
        }
        else
        {
            System.out.println("CurrentThread is "+Thread.currentThread());
            throw new Exception("taCode error");
        }
    }


}
