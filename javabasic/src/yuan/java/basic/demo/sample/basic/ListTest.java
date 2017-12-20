package yuan.java.basic.demo.sample.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanxin on 17/11/21.
 */
public class ListTest
{
    public static void main(String[] args)
    {

        List<Car> cars = new ArrayList<>(3);
        List<Person> persons = new ArrayList<>(2);
        persons.add(new Person("women"));
        persons.add(new Person("daxin"));
        Car car = new Car();
        for (int i = 0; i <persons.size() ; i++)
        {
            car.setName(persons.get(i).getName());
            cars.add(car);
        }
        cars.stream().forEach(car1 -> {
            System.out.println(car1.getName());
        });
//        List<String> list = Arrays.asList("hello","world");
//        String he = list.get(0);
//        System.out.println(he);
    }
}
