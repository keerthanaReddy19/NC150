package arrays;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] > intervals[i][0]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);

            } else {
                merged.add(prev);
                prev = intervals[i];
            }

        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }
}
