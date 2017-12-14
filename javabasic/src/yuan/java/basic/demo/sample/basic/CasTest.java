package yuan.java.basic.demo.sample.basic;

/**
 * Created by yuanxin on 17/12/13.
 */
public class CasTest
{
    private transient volatile int sizeCtl;

//    private static final sun.misc.Unsafe U;
//
//    private static final long SIZECTL;

//    static
//    {
//        try
//        {
//            U = sun.misc.Unsafe.getUnsafe();
//            Class<?> k = ConcurrentHashMap.class;
//            SIZECTL = U.objectFieldOffset
//                (k.getDeclaredField("sizeCtl"));
//        }
//        catch (Exception e)
//        {
//            throw new Error(e);
//        }
//    }

    public void test()
    {
        if (true)
        {
            try
            {
                if (false)
                {
                    System.out.printf("hello");
                }

            }
            finally
            {
                sizeCtl = 4;
            }
        }
         int NCPU = Runtime.getRuntime().availableProcessors();

        System.out.println(NCPU);
        System.out.println(sizeCtl);

    }

    public static void main(String[] args)
    {
        CasTest t = new CasTest();
        t.test();
    }

}
