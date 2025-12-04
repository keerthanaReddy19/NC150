package twopointer;

public class TwoSumII_Sorted {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0;
        int right = len-1;

        while(left<right)
        {
            if(numbers[left]+numbers[right]==target)
            {
                return new int[]{left+1, right+1};
            }
            if(numbers[left]+numbers[right]<target)
                left++;
            else
            {
                right--;
            }


        }
        return new int[0];


    }
}
