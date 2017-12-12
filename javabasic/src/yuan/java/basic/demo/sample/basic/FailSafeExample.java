package yuan.java.basic.demo.sample.basic;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuanxin on 17/12/11.
 */
public class FailSafeExample
{
    public static void main(String[] args)
    {
        ConcurrentHashMap <String,String> premiumPhone =
            new ConcurrentHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC Two");
        String value = premiumPhone.put("HTC", "HTC one");
        System.out.println(value);
        premiumPhone.put("Samsung","S5");

        Iterator iterator = premiumPhone.keySet().iterator();

        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }
    }
}
