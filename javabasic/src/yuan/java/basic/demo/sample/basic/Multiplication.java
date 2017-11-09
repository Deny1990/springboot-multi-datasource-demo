package yuan.java.basic.demo.sample.basic;

/**
 * Created by yuan on 17/11/5.
 */
public class Multiplication {
    public static void main(String[] args) {
       int i,j,k;
        for ( i = 0; i < 9; i++) {
            for (k = 0; k < i; k++) {
                System.out.println("    ");
            }
            for (j = 0; j <9 ; j++) {
                System.out.printf("%d * %d = %d ",i,j,i*j);
                System.out.println(" ");
            }
        }
    }
}
