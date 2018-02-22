package yuan.java.basic.demo.sample.algorithm;

/**
 * Created by yuan on 18/1/27.
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        //保证  a 的字符串长度大于b 的
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        int pa = a.length() - 1;
        int pb = b.length() - 1;

        //每一位的和
        int sum = 0;
        //求和时的进位
        int jinwei = 0;
        //二进制结果
        String res = "";
        while (pb >= 0) {
            sum = (int) (a.charAt(pa) - '0') + (int) (b.charAt(pb) - '0') + jinwei;
            jinwei = sum / 2;
            res =  (sum % 2)+res;
            pa--;
            pb--;
        }

        while (pa >=0) {
            sum = (int)(a.charAt(pa) - '0')+ jinwei;
            jinwei = sum/2 ;
            res = (sum % 2 ) + res ;
            pa--;
        }
        if(jinwei == 1){
            res = "1" + res;
        }
        return res;

    }

    public static void main(String[] args) {
        String bb = addBinary("11", "1");
        System.out.println(bb);
    }
}
