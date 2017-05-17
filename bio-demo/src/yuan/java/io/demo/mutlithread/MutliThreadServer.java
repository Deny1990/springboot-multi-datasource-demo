package yuan.java.io.demo.mutlithread;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yuanxin on 17/5/17.
 */
public class MutliThreadServer
{




    public static void main(String[] args)
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(10086);
            Socket socket = null;
            int count = 0;//记录客户端的数量
            while (true)
            {
                socket = serverSocket.accept();
                count++;
                ServerThread serverThread = new ServerThread(count,socket);
                serverThread.start();
                System.out.println("客户端连接的数量：" + count);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
