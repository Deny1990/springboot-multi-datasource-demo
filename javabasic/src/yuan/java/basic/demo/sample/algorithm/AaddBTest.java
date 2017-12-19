package yuan.java.basic.demo.sample.algorithm;

/**
 * Created by yuanxin on 17/12/19.
 */
public class AaddBTest
{
    /*
    * @param : An integer
    * @param : An integer
    * @return: The sum of a and b
   */
    public int aplusb(int a, int b)
    {
        if( b == 0){
            return a;
        }
        if( a ==0){
            return b;
        }
        int c = a ^ b;
        int d = (a & b) << 1;
        return aplusb(c,d);
        // write your code here
    }

    public static void main(String[] args)
    {
        AaddBTest test = new AaddBTest();
        int sum = test.aplusb(2, 2);
        System.out.println(sum);
        int sum2 = add(2,2);
        System.out.println(sum2);
    }
    public static int add( int number_1, int number_2 )
    {
        int sum = 0;
        int carry = 0;
        do
        {
            sum = number_1 ^ number_2;
            carry = ( number_1 & number_2 ) << 1;


            number_1 = sum;
            number_2 = carry;
        }
        while ( carry != 0 );


        return sum;
    }


}
