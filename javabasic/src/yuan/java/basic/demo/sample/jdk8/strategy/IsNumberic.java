package yuan.java.basic.demo.sample.jdk8.strategy;

/**
 * Created by yuan on 17/6/8.
 */
public class IsNumberic  implements ValidationStrategy{
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
