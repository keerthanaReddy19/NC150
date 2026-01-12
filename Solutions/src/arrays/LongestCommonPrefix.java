package arrays;

/*LC 14
After sorting the strings, the most dissimilar strings appear at the beginning and end.
Any prefix common to all strings must be common to these two.
So we compare the first and last strings character by character to find the longest common prefix.
Time: O(nlogn.m) (O(nlogn) -> sorting, O(m) -> prefix scan)
 */

import java.util.Arrays;

public class LongestCommonPrefix {

    public String prefixLength(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs); // O(n log n) n: number of strings

        int length = strs.length;
        char first[] = strs[0].toCharArray();
        char last[] = strs[length - 1].toCharArray();

        StringBuilder s = new StringBuilder();

        int minLen = Math.min(first.length, last.length);

        //O(m) m: len of shortest string
        for (int i = 0; i < minLen; i++) {
            if (first[i] == last[i]) {
                s.append(first[i]);
            } else break;
        }
        return s.toString();
    }
}