package arrays;

import java.util.HashMap;

public class SubArraySum {
    public int subarraySum(int[] nums, int k)
    {

        int n = nums.length;
        int prefix_sum[] = new int[n];
        int count = 0;
        int sum = 0;

        HashMap<Integer, Integer> freq_sum = new HashMap<>();

        freq_sum.put(0, 1);

        for(int i = 0; i<n; i++)
        {
            sum = sum + nums[i];
            prefix_sum[i] = sum;

            int j = prefix_sum[i]-k;
            if(freq_sum.containsKey(j))
            {
                count+=freq_sum.get(j);
            }

            freq_sum.put(prefix_sum[i], freq_sum.getOrDefault(prefix_sum[i], 0)+1);


        }
        return count;
    }
}
