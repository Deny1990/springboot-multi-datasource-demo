package yuan.java.basic.demo.sample.callback;

/**
 * Created by yuanxin on 17/5/11.
 */
public class Server
{
    public void getClientMsg(CSCallback csCallback,String msg){
        System.out.println("服务端: 服务端接收到客户端发送的消息为:"+msg);
        try
        {
            Thread.sleep(5*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("服务端:数据处理成功,返回状态 200");
        String status = "200";
        csCallback.process(status);
    }
}
