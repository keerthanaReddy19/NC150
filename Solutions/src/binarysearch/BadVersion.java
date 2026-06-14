
package binarysearch;

/*
 The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class BadVersion extends VersionControl {

    public BadVersion(int firstBad) {
        super(firstBad);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

class VersionControl {
    private int firstBad;

    public VersionControl(int firstBad) {
        this.firstBad = firstBad;
    }

    public boolean isBadVersion(int version) {
        return version >= firstBad;
    }
}
