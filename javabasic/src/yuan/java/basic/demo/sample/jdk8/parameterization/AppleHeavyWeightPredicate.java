package yuan.java.basic.demo.sample.jdk8.parameterization;

/**
 * Created by yuanxin on 17/5/24.
 */
public class AppleHeavyWeightPredicate implements ApplePredicate
{
    @Override
    public boolean test(Apple apple)
    {
        return apple.getWeight() >150;
    }
}
