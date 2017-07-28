package yuan.java.basic.demo.sample.mutilthread.base;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yuanxin on 17/7/27.
 */
public class ReadWriteMap<K,V>
{
    private final Map<K,V> map;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock r = lock.readLock();
    private final Lock w = lock.writeLock();

    public ReadWriteMap(Map<K,V> map){
        this.map = map;
    }

    public V put(K key ,V value){
      w.lock();
        try
        {
            return map.put(key,value);
        }finally
        {
            w.unlock();
        }
    }
    public V get(Object key){
        r.lock();
        Object b = new Object();
//        synchronized (b){
            try
            {
                b.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
//        }
        try{
            return map.get(key);
        }finally
        {
            r.unlock();
        }
    }
}
