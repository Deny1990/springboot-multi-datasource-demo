package yuan.java.basic.demo.sample.jdk8.streams;

import yuan.java.basic.demo.sample.basic.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanxin on 17/12/15.
 */
public class ListTest
{
    public static void main(String[] args)
    {
        Car car = new Car("benchi");
        Car car1 = new Car("baoma");
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);
        cars.stream().forEach(c -> {
           c.setAddress("deguo");
        });
        cars.stream().forEach(c ->{
            System.out.println(c.toString());
        });
    }
}
