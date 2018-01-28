package yuan.java.basic.demo.sample.algorithm;

/**
 * Created by yuan on 18/1/28.
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public Singleton getInstance() {
        return instance;
    }
}
