package yuan.java.basic.demo.sample.algorithm;

import java.util.ArrayList;

/**
 * Created by yuanxin on 17/7/3.
 */
public class SplitArray
{
    public static void main(String[] args)
    {
        int[] aa = {1, 1, 1, 2, 0, 2, 5, -1, 3};
        split(aa);
    }

    public static void split(int[] intArray)
    {
        ArrayList<Integer> list = new ArrayList<>(4);

        int fenxiabiao = 0;
        //f为假设第一个分割符下标位置
        for (int f = 1; f < intArray.length - 3; f++)
        {
            list.add(f);
            //计算分割符之前数字之和
            int sum = 0;
            for (int j = 0; j < f; j++)
            {
                sum += intArray[j];
            }
            //依次计算下个分割符号位置
            int sum2 = 0;

            //从计算下标的后一个元素开始计算和
            for (int j = f + 1; j < intArray.length; )
            {
                sum2 += intArray[j];
                if (fenxiabiao <= 3)
                {
                    if (sum == sum2)
                    {
                        //下一个元素为分割符下标
                        fenxiabiao++;
                        list.add(j + 1);
                        sum2 = 0;
                        //跳过分割元素,继续求和
                        j = j + 2;
                    }
                    else
                    {
                        j++;
                    }
                }
                else
                {
                    j++;
                }

            }
            if (fenxiabiao == 4)
            {
                list.remove(3);
                list.stream().forEach(System.out::println);
                break;
            }
            else
            {
                list.clear();
            }
        }

    }
}
