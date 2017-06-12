package yuan.java.basic.demo.sample.jdk8.designpattern.template;

/**
 * Created by yuanxin on 17/6/9.
 */
abstract class OnlineBanking
{
    public void processCustomer(int id)
    {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);

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
}
