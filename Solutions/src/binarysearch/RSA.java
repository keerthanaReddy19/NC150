package binarysearch;

public class RSA {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            //check if left half is sorted
            if (nums[left] <= nums[mid]) {

                //find in target is in boundary of left to mid
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                }

                //right half
                else {
                    left = mid + 1;
                }

            }

            //if left is not sorted, check right half
            else if (nums[right] >= target && nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }
}
