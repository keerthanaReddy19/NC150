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

        if (strs == null || strs.length == 0) return "";


        StringBuilder result = new StringBuilder();

        Arrays.sort(strs);

        // Get the first and last strings
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        //compare
        for (int i = 0; i < first.length; i++) {
            if (first[i] != last[i]) break;
            result.append(first[i]);
        }

        return result.toString();
    }

}
