package binarysearch;

public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int peak = left;

        int low = 0;
        int high = peak;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == mountainArr.get(mid)) {
                return mid;
            }

            if (target < mountainArr.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = peak + 1;
        high = mountainArr.length() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == mountainArr.get(mid)) {
                return mid;
            }

            // descending side
            if (target > mountainArr.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}

interface MountainArray {
    int get(int index);
    int length();
}