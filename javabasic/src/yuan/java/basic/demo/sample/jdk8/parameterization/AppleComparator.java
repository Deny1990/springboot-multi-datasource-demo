package yuan.java.basic.demo.sample.jdk8.parameterization;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Created by yuanxin on 17/5/31.
 */
public class AppleComparator implements Comparator<Apple>
{
    @Override
    public int compare(Apple a1, Apple a2)
    {
        return a1.getWeight().compareTo(a2.getWeight());
    }

    public static void sortApple()
    {
        List list = Arrays.asList(new Apple("greeen", 100l), new Apple("red", 38l));
        list.sort(new AppleComparator());
    }

    public static void sortAppleByAnonymous()
    {
        List list = Arrays.asList(new Apple("greeen", 100l), new Apple("red", 38l));
        list.sort(new Comparator<Apple>()
        {
            @Override
            public int compare(Apple o1, Apple o2)
            {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });


    }


   public static void sortByLambda(){
       List<Apple> list = Arrays.asList(new Apple("greeen", 100l), new Apple("red", 38l));
       list.sort((a1,a2)->a1.getWeight().compareTo(a2.getWeight()));
   }

    public static void soryByComparing(){
        List<Apple> list = Arrays.asList(new Apple("greeen", 100l), new Apple("red", 38l));
        list.sort(Comparator.comparing((Apple a)-> a.getWeight()));
    }

    public static void soryByMethodReference()
    {
        List<Apple> list = Arrays.asList(new Apple("greeen", 100l), new Apple("red", 38l));
        list.sort(Comparator.comparing(Apple::getWeight));
    }
}
