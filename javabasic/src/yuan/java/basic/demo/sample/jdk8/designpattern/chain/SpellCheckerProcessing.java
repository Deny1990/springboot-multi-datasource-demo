package yuan.java.basic.demo.sample.jdk8.designpattern.chain;

/**
 * Created by yuanxin on 17/6/12.
 */
public class SpellCheckerProcessing extends  ProcessObject<String>
{
    @Override
    protected String handleWork(String input)
    {
        return input.replaceAll("labda","lambda");
    }

    public static void main(String[] args)
    {
        ProcessObject<String> p1 = new HeaderTextProcessing();
        ProcessObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("aren't labdas really sexy?!!");
        System.out.println(result);
    }
}
