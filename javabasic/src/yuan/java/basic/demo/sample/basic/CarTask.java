package yuan.java.basic.demo.sample.basic;

/**
 * Created by yuanxin on 17/10/13.
 */
public class CarTask implements Runnable
{
    private Car car;

    public CarTask(Car car)
    {
        this.car = car;
    }

    @Override
    public void run()
    {
        car.changeData();
        try
        {
            Thread.currentThread().sleep(10000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        car.printCar();
    }

    public Car getCar()
    {
        return car;
    }

    public void setCar(Car car)
    {
        this.car = car;
    }
}
