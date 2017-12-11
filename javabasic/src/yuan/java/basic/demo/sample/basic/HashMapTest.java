package yuan.java.basic.demo.sample.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuanxin on 17/12/5.
 */
public class HashMapTest
{
    public static void main(String[] args)
    {
        Map<String,String> map = new HashMap(3);
        map.put("hello","hh");
        map.put("hello111","hh");
        map.put("hello2222","hh");
        map.forEach((key,value)->{
            System.out.println("key =  "+key+ " ,value = "+value);
        });
    }
}
