package yuan.java.basic.demo.sample.basic;

/**
 * Created by yuanxin on 17/10/13.
 */
public class SynchronizedTest
{
    public static void main(String[] args)
    {
        Car car = new Car("benchi","shanghai");
        car.printCar();
        System.out.println(System.currentTimeMillis());
        new Thread(new CarTask(car)).start();
        car.printCar();
        System.out.println(System.currentTimeMillis());

    }

}
