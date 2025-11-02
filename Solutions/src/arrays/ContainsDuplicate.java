package arrays;

import java.util.HashSet;

public class ContainsDuplicate {

    //Brute Force
    public boolean duplicateCheck(int[] nums) {
        if(nums.length==0)
        {
            return false;
        }
        for(int i = 0; i< nums.length;i++)
        {
            for(int j = i+1; j< nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    return true;
                }
            }
        }
        return false;
    }

    //HashMap
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> count = new HashSet<>();

        for(int i =0; i<nums.length;i++)
        {
            if(count.contains(nums[i]))
            {
                return true;
            }
            count.add(nums[i]);
        }
        return false;
    }
}

