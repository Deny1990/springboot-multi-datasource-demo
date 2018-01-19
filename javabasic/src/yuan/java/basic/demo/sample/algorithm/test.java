package yuan.java.basic.demo.sample.algorithm;

/**
 * Created by yuanxin on 17/7/3.
 */
public class test
{
    public static void main(String[] args)
    {
//        int a= 4;
//        int b = (a --);
//        System.out.println(b);
//        System.out.println(a);
        int a =1;
        int b =2;
        int ch = 'a';
        int ch1 = 'b';
        int ch2 = 'c';
        int ch3 = ' ';


        System.out.println(ch);
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);
        int c = a + b;
        System.out.println(c);
        int[] targethash = new int[256];
        minWindow("ADOBECODEBANC","ABC");


    }

    static int initTargetHash(int []targethash, String Target) {
        int targetnum =0 ;
        for (char ch : Target.toCharArray()) {
            targetnum++;
            targethash[ch]++;
        }
        return targetnum;
    }
    static  boolean valid(int []sourcehash, int []targethash) {

        for(int i = 0; i < 256; i++) {
            if(targethash[i] > sourcehash[i])
                return false;
        }
        return true;
    }
    public static String minWindow(String Source, String Target) {
        // queueing the position that matches the char in T
        int ans = Integer.MAX_VALUE;
        String minStr = "";

        int[] sourcehash = new int[256];
        int[] targethash = new int[256];

        initTargetHash(targethash, Target);
        int j = 0, i = 0;
        for(i = 0; i < Source.length(); i++) {
            while( !valid(sourcehash, targethash) && j < Source.length()  ) {
                sourcehash[Source.charAt(j)]++;
                System.out.println(Source.charAt(j));
                j++;
            }
            if(valid(sourcehash, targethash) ){
                if(ans > j - i ) {
                    ans = Math.min(ans, j - i );
                    minStr = Source.substring(i, j );
                }
            }
            sourcehash[Source.charAt(i)]--;
        }
        return minStr;
    }
}
