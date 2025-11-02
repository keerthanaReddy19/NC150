package arrays;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> values = new HashMap<>();
        for(int i = 0; i<nums.length;i++)
        {
            if(values.containsKey(nums[i]))
            {
                return new int[]{values.get(nums[i]), i};
            }
            values.put(target-nums[i],i);
        }
        return new int[0];
    }
}

