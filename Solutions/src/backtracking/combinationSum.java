package backtracking;
import java.util.*;

public class combinationSum {

    private List<List<Integer>> output = new ArrayList();
    private int n;



    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        ArrayList<Integer> currCombination = new ArrayList<Integer>();
        n = candidates.length;

        backtrackSum(currCombination, 0, candidates, target);
        return output;

    }

    void backtrackSum(ArrayList<Integer> currCombination, int index, int[] candidates, int target)
    {

        if(index==candidates.length || target<0)
        {
            return;
        }

        if(target == 0)
        {
            output.add(new ArrayList<Integer>(currCombination));
            return;
        }


        currCombination.add(candidates[index]);

        //multiple
        backtrackSum(currCombination, index, candidates, target-candidates[index]);

        //exclusion
        currCombination.remove(currCombination.size()-1);
        backtrackSum(currCombination, index+1, candidates, target);


    }
}
