package yuan.java.basic.demo.sample.jdk8.designpattern.chain;

/**
 * Created by yuanxin on 17/6/12.
 */
public class HeaderTextProcessing extends ProcessObject<String>
{
    @Override
    protected String handleWork(String input)
    {
        return "From Raoul,Mario and Alan"+input;
    }

}
