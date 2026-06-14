package arrays;
/*
        0 1 2
nums = [1,2,3], k = 3

prefix_sum = 1,
count = 0
sum = 1

0:
prefix_sum[0] = 1;
count = 0
sum = 1
j = prefix_sum[0] - 3 = 2
Freq_sum: j? -2? NO

1:
prefix_sum[1] : 3
sum = 3
j = prefix_sum[1]-K = 3-3 =0
count = 1



2:
prefix[2] = 6
sum = 6
j= 3
count = 2





freq_sum - K           V
         prefix_sum   count
           0           1
           1           1
           3           1
           6           1


 */
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
