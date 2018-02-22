package yuan.java.basic.demo.sample.algorithm;

/**
 * Created by yuan on 17/12/19.
 */
public class TailZero {
//    public static void main(String[] args) {
////        long n = 11;
//        long n = 105;
////        long factorial = getFactorial(n);
//        int fivenums = 0;
//        int twonums = 0;
//        int tenums = 0;
//        for (long i = n; i > 0; i--) {
//            if (i % 5 == 0 && i % 2 != 0) {
//                fivenums++;
//            }
//            if (i % 2 == 0 && i % 5 != 0) {
//                twonums++;
//            }
//            if (i % 10 == 0) {
//                tenums++;
//            }
//        }
//        System.out.println(fivenums);
//        System.out.println(twonums);
//        System.out.println(tenums);
//        int num = fivenums > twonums ?  twonums : fivenums;
//        System.out.println(num + tenums);
////        System.out.println(factorial);
////        int j = 0;
////        long fmod = 0;
////        do {
////            fmod = factorial % 10;
////            if (fmod == 0) {
////                j++;
////                factorial = factorial / 10;
////            }
////        } while (fmod == 0);
////        System.out.println(j);
//    }

    public static long getFactorial(long n) {
        long multiplied = 1;
        for (long i = 1; i <= n; i++) {
            multiplied = i * multiplied;
        }
        return multiplied;
    }

    public static long trailingZeros(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }

    public static int trailingZerosInt(int n) {
        int sum = 0;
        while(n != 0){
            sum = sum + n/5;
            n = n/5;
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum = trailingZerosInt(27);
        System.out.println(sum);
    }
}
