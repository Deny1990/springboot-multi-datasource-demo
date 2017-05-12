package yuan.java.basic.demo.sample.callback;

/**
 * Created by yuanxin on 17/5/11.
 */
public class Client implements CSCallback
{
    private Server server;

    public Client(Server server)
    {
        this.server = server;
    }

    public void sendMsg(String msg){
        System.out.println("客户端:客户端发送的消息为:"+msg);
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                server.getClientMsg(Client.this,msg);
            }
        }).start();
        System.out.println("客户端:异步发送消息成功");
    }

    @Override
    public void process(String status)
    {
        System.out.println("客户端:服务端回调状态为:"+status);
    }
}
