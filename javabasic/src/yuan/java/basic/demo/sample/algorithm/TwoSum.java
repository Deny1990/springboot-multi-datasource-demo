package yuan.java.basic.demo.sample.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuanxin on 17/12/19.
 */
public class TwoSum
{
    public int[] twoSum(int[] nums, int target)
    {
        int[] re = new int[2];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++)
        {
            int numberOne = nums[i];
            for (int j = i + 1; j < nums.length; j++)
            {
                int numberTwo = nums[j];
                if (numberOne + numberTwo == target)
                {
                    re[0] = i;
                    re[1] = j;
                    flag = true;
                    break;
                }

            }
            if (flag)
            {
                break;
            }
        }
        return re;
    }

    public int[] twoSum2(int[] nums, int target)
        throws Exception
    {
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++)
        {
            int part = target - nums[j];
            if (map.containsKey(part) && (int)map.get(part) != j)
            {
                return new int[] {j, (int)map.get(part)};
            }
        }
        throw new Exception();
    }

    public int[] twoSum3(int[] nums, int target)
        throws Exception
    {

        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++)
        {
            int part = target - nums[j];
            if (map.containsKey(part) && (int)map.get(part) != j)
            {
                return new int[] {j, (int)map.get(part)};
            }
        }
        throw new Exception();
    }
}
