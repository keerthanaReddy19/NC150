package binarysearch;

public class Sqrt {
    public int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int left = 2;
        int right = x / 2;
        long mid_num;


        while (left <= right) {
            int mid = left + (right - left) / 2;
            mid_num = (long) mid * mid;


            if (mid_num == x) {
                return mid;
            } else if (mid_num > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }


        }
        return right;
    }
}
