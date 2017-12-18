package yuan.java.basic.demo.sample.basic;

/**
 * Created by yuanxin on 17/12/12.
 */
public class MoveBitTest {

    static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash

    public static void main(String[] args) {
        String hello ="hello";
        int hashCode  = hello.hashCode();
        System.out.println("hashCode 为:");
        printBinaryInt(hashCode);
        int hash = spread(hashCode);
        System.out.println("hash 为:");
        printBinaryInt(hash);

        int n = 16;
        System.out.println("n-1");
        printBinaryInt(n-1);
        System.out.println("n");
        printBinaryInt(n);
        System.out.println("(n-1)&hash");
        int i = (n-1)&hash;
        System.out.println("i ="+i);
        printBinaryInt(i);
        System.out.println("(n)&hash");
        int in = (n)&hash;
        printBinaryInt(in);

    }

    public static void printBinaryInt(int i) {
        for (int j = 31; j >= 0; j--) {
            if (((1 << j) & i) != 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
    }
    static final int spread(int h) {
        System.out.println("(h >>> 16)");
        printBinaryInt(h>>>16);
        int move = (h ^ (h >>> 16));
        System.out.println("(h ^ (h >>> 16))");
        printBinaryInt(move);
        System.out.println("HASH_BITS");
        printBinaryInt(HASH_BITS);
        return (h ^ (h >>> 16)) & HASH_BITS;
    }
}
