package yuan.java.basic.demo.sample.algorithm;

/**
 * Created by yuan on 17/12/18.
 */
public class ChoiceSort {
    /*
    * @param A: an integer array
    * @return:
    */
    public void sortIntegers(int[] A) {
        // write your code here

        for(int i= A.length -1; i>0; i--){
            int max = 0;
            for(int j = 0; j < i ; j++){
                if(A[max] < A[j+1]){
                    max = j+1 ;
                }
            }
            //max值和第i位交换
            if(max != i){
                int temp = 0;
                temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }

        }
    }

    public static void main(String[] args) {
        ChoiceSort sort = new ChoiceSort();
        int[] aa = {3,2,1,4,5};
        sort.sortIntegers(aa);
        for (int i = 0;i<aa.length;i++){
            System.out.println(aa[i]);
        }
    }
}
