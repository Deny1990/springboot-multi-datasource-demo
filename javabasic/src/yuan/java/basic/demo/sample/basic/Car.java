package yuan.java.basic.demo.sample.basic;

/**
 * Created by yuanxin on 17/10/13.
 */
public class Car
{
    private String name;

    private String address;

    public Car(String name, String address)
    {
        this.name = name;
        this.address = address;
    }

    public synchronized void changeData()
    {
        this.name = "falali";
        this.address = "bolin";
    }

    public void printCar()
    {
        System.out.println("CurrentThread is "+Thread.currentThread()+"car name is "+ this.name);
    }

    public static void main(String[] args) {
        Car car = new Car("benchi","songgang");


    }
}
