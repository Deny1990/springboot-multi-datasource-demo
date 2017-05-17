package yuan.java.io.demo.mutlithread;

import java.io.*;
import java.net.Socket;

/**
 * Created by yuanxin on 17/5/17.
 */
public class ServerThread extends Thread
{
    //服务器线程处理 和本线程相关的socket
    Socket socket = null;

    public ServerThread(int count,Socket socket)
    {
        super(String.valueOf(count));
        this.socket = socket;
    }

    public void run()
    {
        try{
            System.out.println("currentThread is "+Thread.currentThread().getName());
            //3、获取输入流，并读取客户端信息
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null)
            {
                System.out.println("Hello,我是服务器，客户端说：" + info);
            }
            socket.shutdownInput();//关闭输入流
            //4、获取输出流，响应客户端的请求
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("Hello World！");
            pw.flush();
            //5、关闭资源
            pw.close();
            os.close();
            br.close();
            isr.close();
            is.close();
            socket.close();
        }catch (Exception e){

        }

    }

}
