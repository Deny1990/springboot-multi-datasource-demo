package yuan.java.basic.demo.sample.mutilthread.ackfile;

import java.util.Random;

/**
 * Created by yuanxin on 17/6/19.
 */
public class AckFile extends BaseAckFile
{
    private boolean isFlag = false;

    private ThreadLocal<Integer> sumLocal = new ThreadLocal<Integer>(){
        protected Integer initialValue() {
            return Integer.valueOf(0);
        }
    };
    public Integer process(){
       int i = new Random().nextInt();
        System.out.println("i 的值为"+ i +"currentThread is "+Thread.currentThread());
        if(i>100){
            System.out.println(" i >100,i = "+ i + "currentThreade is "+Thread.currentThread());
            isFlag = true;
            System.out.println("currentThread is"+Thread.currentThread()+" flag  = "+isFlag);
        }
        return i;
    }

    public Integer processInteger(int i){
        sumLocal.set(100);
      int sum = sumLocal.get().intValue() +i;
        return sum;
    }
}
