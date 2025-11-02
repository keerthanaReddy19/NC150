package arrays;

import java.util.*;

//1,2,3,4,5    T =  6
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3)
        {
            return new ArrayList<>();
        }

        HashSet<List<Integer>> hs = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            {
                int  p1 = i + 1;
                int  p2 = nums.length - 1;

                while (p1 < p2) {
                    int sum = nums[p1] + nums[p2] + nums[i];

                    if (sum == 0) {
                        hs.add(Arrays.asList(nums[p1], nums[p2], nums[i]));
                        p1++;
                        p2--;
                    } else if (sum < 0) {
                        p1++;
                    } else {
                        p2--;
                    }
                }
            }


        }
        return new ArrayList<>(hs);
    }
}