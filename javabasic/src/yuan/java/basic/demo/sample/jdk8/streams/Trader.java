package yuan.java.basic.demo.sample.jdk8.streams;

/**
 * Created by yuanxin on 17/6/1.
 */
public class Trader
{
    private  String name;
    private  String city;

    public Trader(String name, String city)
    {
        this.name = name;
        this.city = city;
    }

    public String getName()
    {
        return name;
    }

    public String getCity()
    {
        return city;
    }
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
