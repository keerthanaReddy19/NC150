package backtracking;

import java.util.*;

public class combinationSum2 {
    private List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, target, 0);
        return output;
    }

    /*
    candidate = [1,1,2,5,6,7,10]
    t = 8
    s = 0 */
    private void backtrack(List<Integer> curr, int[] cand, int remain, int start) {
        if (remain == 0) {
            output.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < cand.length; i++) {

            //skip duplicates at same level
            if (i > start && cand[i] == cand[i-1])
                continue;

            if (cand[i] > remain) break;

            curr.add(cand[i]);
            //each index once
            backtrack(curr, cand, remain - cand[i], i+1);
            curr.remove(curr.size()-1);
        }
    }


}
