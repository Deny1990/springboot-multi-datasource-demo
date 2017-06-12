package yuan.java.basic.demo.sample.jdk8.designpattern.chain;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by yuanxin on 17/6/12.
 */
public class ChainLambda
{
    public static void main(String[] args)
    {

        UnaryOperator<String> headerProcessing = (String text) -> {
            return "From Raoul, Marion and Alan" + text;
        };

        UnaryOperator<String> spellCheckerProcessing = (String text) -> {
            return text.replaceAll("labda", "lambda");
        };
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);

        String result = pipeline.apply("aren't labdas really sexy?!!");
        System.out.println(result);
    }
}
