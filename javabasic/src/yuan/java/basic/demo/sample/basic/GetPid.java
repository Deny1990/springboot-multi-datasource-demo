package yuan.java.basic.demo.sample.basic;

import sun.management.VMManagement;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by yuanxin on 18/1/11.
 */
public class GetPid
{
    public static final int jvmPid() {
        try {
            RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
            Field jvm = runtime.getClass().getDeclaredField("jvm");
            jvm.setAccessible(true);
            VMManagement mgmt = (VMManagement) jvm.get(runtime);
            Method pidMethod = mgmt.getClass().getDeclaredMethod("getProcessId");
            pidMethod.setAccessible(true);
            int pid = (Integer) pidMethod.invoke(mgmt);
            return pid;
        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args)
        throws InterruptedException
    {
        System.out.println(jvmPid());
        Thread.sleep(100000L);
    }
}
