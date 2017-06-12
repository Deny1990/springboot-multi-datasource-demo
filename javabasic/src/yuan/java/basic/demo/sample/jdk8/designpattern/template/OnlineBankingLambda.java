package yuan.java.basic.demo.sample.jdk8.designpattern.template;

import java.util.function.Consumer;

/**
 * Created by yuanxin on 17/6/9.
 */
public class OnlineBankingLambda
{
    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy)
    {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

    // dummy Customer class
    static private class Customer
    {
    }

    // dummy Datbase class
    static private class Database
    {
        static Customer getCustomerWithId(int id)
        {
            return new Customer();
        }
    }

    public static void main(String[] args)
    {
        int value = (int)(Math.pow(2,32)-1);
        System.out.println(value);
        System.out.println(Integer.MAX_VALUE);
    }
}

