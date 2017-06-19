package yuan.java.basic.demo.sample.mutilthread.ackfile;

/**
 * Created by yuanxin on 17/6/19.
 */
public class AckFileThread extends Thread
{
    private AckFile ackFile;
    public AckFileThread(AckFile ackFile){
       this.ackFile = ackFile;
    }
    public  void run(){
       ackFile.process();
    }
}

