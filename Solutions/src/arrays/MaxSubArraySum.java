package arrays;
//LC53 Kadane's Algorithm
public class MaxSubArraySum {
    public int maxSubArray(int[] num) {

        int n = num.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0;i<n;i++){
            sum += num[i];
            max = Math.max(sum,max);

            if(sum<0)
            {
                sum = 0;
            }
        }

        return max;
    }
}
