package arrays;

/*
LC 88
Since nums1 has extra space at the end, merge from right to left, placing the larger of the two current elements into its final position.
If nums2 is exhausted, the remaining elements in nums1 are already correctly placed; if nums1 is exhausted, we copy all remaining elements from nums2.
TC : O(m+n)
 */
public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;

        for(int p = m+n-1; p>=0;p--)
        {
            if(p2<0)
            {
                break;
            }

            if(p1>=0 && nums1[p1] > nums2[p2])
            {
                nums1[p] = nums1[p1];
                p1--;
            }
            else
            {
                nums1[p] = nums2[p2];
                p2--;
            }
        }
    }
}
