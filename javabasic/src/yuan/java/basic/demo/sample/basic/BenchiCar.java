package yuan.java.basic.demo.sample.basic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by yuanxin on 17/12/20.
 */
public class BenchiCar extends Car
{
    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("BenchiCar{");
        sb.append('}');
        sb.append(this.getName());
        return sb.toString();
    }

    public static void main(String[] args)
    {
        try
        {
            Class carClass = Class.forName("yuan.java.basic.demo.sample.basic.BenchiCar");

            BenchiCar car  = (BenchiCar)carClass.newInstance();
            Method method = carClass.getMethod("setName",String.class);

            method.invoke(car,"benchi");
            System.out.println(car);
            System.out.printf("hello");

            Field[] fields = carClass.getFields();
            for (int i = 0; i <fields.length ; i++)
            {
                System.out.println(fields[i].getName());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
