package yuan.java.basic.demo.sample.jdk8.lambda;

import yuan.java.basic.demo.sample.jdk8.parameterization.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Created by yuanxin on 17/5/25.
 */
public class FunctionDemo
{
    public static <T, R> List<R> map(List<T> list, Function<T, R> f)
    {
        List<R> result = new ArrayList<>();
        for (T t : list
            )
        {
            result.add(f.apply(t));
        }
        return result;
    }

    public static void main(String[] args)
    {
        List<Integer> integerList = map(Arrays.asList("hello", "worlddd", "womenn"), (String s) -> s.length());
        integerList.stream().forEach(System.out::println);
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        evenNumbers.test(1000);
        Predicate<Integer> oddNumvers = (Integer i) -> i % 2 == 0;
        oddNumvers.test(1000);

    }

    public void testIntConsumer()
    {
        IntConsumer intConsumer = (int i) -> System.out.println(i);
        intConsumer.accept(5);
    }

    public void testIntFunction()
    {
        IntFunction<Car> intFunction = (int i) -> {
            return new Car(i);
        };
        Car car = intFunction.apply(1);
        System.out.println(car.getCardId());
    }

    public void testToDoubleFunction()
    {
        ToDoubleFunction<Car> toDoubleFunction = (Car carTwo) -> carTwo.getCardId();
        double carId = toDoubleFunction.applyAsDouble(new Car(8));
        System.out.println(carId);
    }

    public void testIntToDoubleFunction()
    {
        IntToDoubleFunction intToDouble = (int i) -> {
            return i * 2;
        };
        double testDouble = intToDouble.applyAsDouble(3);
        System.out.println(testDouble);
    }

    public void testBooleanSupplier()
    {
        BooleanSupplier booleanSupplier = () -> {
            return true;
        };
        boolean isTrue = booleanSupplier.getAsBoolean();
        System.out.println(isTrue);
    }

    public void testToIntBiFunction()
    {

        ToIntBiFunction<Car, Apple> toIntBiFunction = FunctionDemo :: test;
        int toInt = toIntBiFunction.applyAsInt(new Car(888), new Apple("red", 77));
        System.out.println(toInt);

    }

    public static int test(Car carOne, Apple apple)
    {
        int carOneId = carOne.getCardId();
        int weight = (int)apple.getWeight();
        return carOneId + weight;
    }


}
