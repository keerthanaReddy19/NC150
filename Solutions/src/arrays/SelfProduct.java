package arrays;
import java.util.*;

public class SelfProduct {
   /* Brute Force
   public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int product = 1;
            for(int j =i+1; j<nums.length;j++)
            {
                product = product * nums[j];
            }
            for(int k = 0;k<i;k++)
            {
                product = product * nums[k];

            }
            result[i] = product;
        }


        return result;
    } */

    //Optimal Solution
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans,1);

        int curr = 1;
        for(int i =0; i<n;i++)
        {
            ans[i]*=curr;
            curr*=nums[i];
        }

        curr =1;
        for(int i=n-1;i>=0;i--)
        {
            ans[i]*=curr;
            curr*=nums[i];

        }
        return ans;
    }
}
