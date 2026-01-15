package arrays;

/*
LC 33
Find the sorted side, check range, binary search there or discard it.
Tc: O(logn)
SC: O(1)
 */

public class RotatedSortedArray {

    public static int search(int nums[], int target)
    {
        int length  = nums.length;
        int low  = 0;
        int high = length-1;

        while(low<=high)
        {
            int mid = low+(high-low)/2;

            if(nums[mid] == target)
            {
                return mid;
            }

            //check if left is sorted
            if(nums[low]<=nums[mid])
            {
                //check if target is in left range
                if(target>=nums[low] && target<nums[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid+1;
                }
            }

            else
            {
                //left is unsorted, so right could be sorted.
                //check if target is in range of right half
                if(target>nums[mid] && target<=nums[high])
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }

            }
        }
        return -1;
    }

}
