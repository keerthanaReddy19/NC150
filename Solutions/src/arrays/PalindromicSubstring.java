package arrays;
/*
LC 647 - Palindromic Substrings

Approach: Expand Around Center (two pointers)

Idea:
Every palindrome has a center.
For each index i, expand in two ways:
  1) Odd-length center at (i, i)       -> counts single chars and odd palindromes
  2) Even-length center at (i, i + 1)  -> counts even palindromes

Each successful expansion (s[left] == s[right]) adds 1 palindrome,
then we expand outward: left--, right++.

Example: "aba" -> "a","b","a","aba"
Time: O(n^2), Space: O(1)
*/

public class PalindromicSubstring {
    public int countSubstrings(String s) {

        int len = s.length();
        int count = 0;

        for(int i=0; i<len; i++)
        {
            count+=checkSubString(s, i, i, count);
            count+=checkSubString(s, i, i+1, count);
        }
        return count;
    }

    int checkSubString(String s, int left, int right, int count)
    {
        int current_count = 0;
        while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right))
        {
            current_count++;
            left  = left-1;
            right = right+1;
        }
        return current_count;
    }
}
