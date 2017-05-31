package yuan.java.basic.demo.sample.jdk8.parameterization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanxin on 17/5/24
 */
public class Apple
{
    private String color;

    private Long weight;

    public Apple(String color,long weight){
        this.color = color;
        this.weight = weight;
    }
    public Long getWeight()
    {
        return weight;
    }

    public void setWeight(long weight)
    {
        this.weight = weight;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory, String color)
    {


        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory)
        {
            if (color.equals(apple.getColor()))
            {
                result.add(apple);
            }
        }
        return result;
    }

}
