package binarysearch;
/*

Boundary search pattern:
when I encounter mid, and it is less than right, I move further left side to see if any lesser value could be found

Traditional BS:
 In RSA, left half elements are always greater than right half elements
 if mid > high:
 mid is in left half; move to right (smaller elements);
 else:
 mid is in right half, which is in ascending order; smallest element could be low to mid i.e in left half

 TC: O(logn)
 SC: O(1)

 */
public class MinRSA {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        int mid;


        while(left<right)
        {
            mid = left+(right-left)/2;

            if(nums[mid]<=nums[right])
            {
                right = mid;
            }

            else
            {
                left = mid+1;
            }

        }

        return nums[left];

    }
}
