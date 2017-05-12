package yuan.java.basic.demo.sample.callback;

/**
 * Created by yuanxin on 17/5/11.
 */
public class CallBackTest
{
    public static void main(String[] args)
    {
        Server server = new Server();
        Client client = new Client(server);
        client.sendMsg("hello,world");
    }
}
