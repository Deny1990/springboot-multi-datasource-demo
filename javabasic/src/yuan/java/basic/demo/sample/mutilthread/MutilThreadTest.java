package yuan.java.basic.demo.sample.mutilthread;

import yuan.java.basic.demo.sample.mutilthread.demoOne.ThreadOne;
import yuan.java.basic.demo.sample.mutilthread.demoOne.ThreadTwo;
import yuan.java.basic.demo.sample.mutilthread.demoThree.SynchronizedDemo3;
import yuan.java.basic.demo.sample.mutilthread.demoThree.ThreadFive;
import yuan.java.basic.demo.sample.mutilthread.demoThree.ThreadSix;
import yuan.java.basic.demo.sample.mutilthread.demoTwo.SynchronizedDemo2;
import yuan.java.basic.demo.sample.mutilthread.demoTwo.ThreadFour;
import yuan.java.basic.demo.sample.mutilthread.demoTwo.ThreadThree;

/**
 * Created by yuanxin on 17/5/10.
 */
public class MutilThreadTest
{
    public static void main(String[] args)
    {
        testSynchronizedDemo3();
    }

    static  void testchronizedDemo1(){
        ThreadOne threadOne = new ThreadOne("threadOne");
        ThreadTwo threadTwo = new ThreadTwo("threadTwo");
        threadOne.start();
        threadTwo.start();
    }
    static void  testSynchronizedDemo2(){
        SynchronizedDemo2 synchronizedDemo2 = new SynchronizedDemo2();
        ThreadThree threadThree = new ThreadThree("threadT");
        threadThree.setSynchronizedDemo2(synchronizedDemo2);
        ThreadFour threadFour = new ThreadFour("threadFour");
        threadFour.setSynchronizedDemo2(synchronizedDemo2);
        threadThree.start();
        threadFour.start();
    }

    static void  testSynchronizedDemo3(){
        SynchronizedDemo3 synchronizedDemo3 = new SynchronizedDemo3();

        ThreadSix threadSix = new ThreadSix("threadSix");
        threadSix.setSynchronizedDemo3(synchronizedDemo3);
        threadSix.start();

        ThreadFive threadFive = new ThreadFive("threadFive");
        threadFive.setSynchronizedDemo3(synchronizedDemo3);

        threadFive.start();

    }

}
