package yuan.java.basic.demo.sample.basic;

/**
 * Created by yuan on 17/12/10.
 */
public class Test {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("hello ");
        getString(sb);
        System.out.println(sb);
    }
    public static void getString(StringBuffer s) {
        s = new StringBuffer("ha");
        s.append("world");
    }
}
