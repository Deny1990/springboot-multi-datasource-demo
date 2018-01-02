package yuan.java.basic.demo.sample.basic;

/**
 * Created by yuanxin on 17/12/31.
 */
public final class FinalTest
{
    private  String name;

    private String address;

    public FinalTest(String name, String address)
    {
        this.name = name;
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("FinalTest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args)
    {
        FinalTest test = new FinalTest("women","dalian");
        System.out.println(test);
        test = new FinalTest("wowo","dddd");

        System.out.println(test);
        test.setName("hel");
        test.setAddress("helllo");
        System.out.println(test);
    }
}
