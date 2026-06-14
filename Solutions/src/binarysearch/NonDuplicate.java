package binarysearch;

public class NonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;


        while (low <= high) {
            mid = low + (high - low) / 2;
            boolean hasEvenLength = (high - mid) % 2 == 0;

            if (mid != nums.length - 1 && nums[mid] == nums[mid + 1]) {
                if (hasEvenLength) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if (mid != 0 && nums[mid] == nums[mid - 1]) {
                if (hasEvenLength) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return -1;
    }

}
