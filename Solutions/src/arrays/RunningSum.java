package arrays;

import java.util.*;

public class RunningSum {
    public static List<Integer> runningSum(List<Integer> numbers) {
        // todo

        if(numbers.isEmpty() || numbers==null)
        {
            return List.of();
        }
        int sum = 0;

        List<Integer> rsum = new ArrayList<>();
        sum = sum + numbers.get(0);
        rsum.add(sum);

        for(int i = 1; i<numbers.size(); i++)
        {
            sum = sum + numbers.get(i);
            rsum.add(sum);
        }


        return rsum;
    }
}
