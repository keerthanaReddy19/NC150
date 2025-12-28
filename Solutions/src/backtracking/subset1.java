package backtracking;

import java.util.*;

public class subset1 {
    private List<List<Integer>> output = new ArrayList();
    private int n;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;

        ArrayList<Integer> currCombination = new ArrayList<Integer>();

        backtrack(nums, currCombination, 0);
        return output;
    }

    public void backtrack(int[] nums, ArrayList<Integer> curr, int index)
    {
        output.add(new ArrayList(curr));

        for(int i = index; i< n; i++)
        {
            curr.add(nums[i]);
            backtrack(nums, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
