package slidingwindow;

/*
HashSet: characters in String
Track max_length on each iteration
 - right-left+1
if character is already present in hashset,
remove the left char from hashset until the repeated char is removed!
 */

import java.util.*;
public class LongestConsecutiveSubstring {
   /* public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

       // Input: s = "abcabcbb"
        HashMap<Character, Integer> seen_list = new HashMap<>();
        int last_dup_index = -1;
        int max_length = 0;

        for(int i =0; i<s.length();i++)
        {
            if(seen_list.containsKey(s.charAt(i)))
            {
                last_dup_index = Math.max(last_dup_index, seen_list.get(s.charAt(i)));

            }

                seen_list.put(s.charAt(i), i);
                max_length = Math.max(max_length, i-last_dup_index);

        }
        return max_length;
    } */

   public int lengthOfLongestSubstring(String s)
   {
       if (s.length() == 0) {
           return 0;
       }
       HashSet<Character> seen_list = new HashSet<>();
       int left = 0;
       int max_length = 0;
       for(int right =0; right<s.length();right++)
       {
           while(seen_list.contains(s.charAt(right)))
           {
              seen_list.remove(s.charAt(left));
              left++;
           }
           seen_list.add(s.charAt(right));
           max_length = Math.max(max_length, right-left+1);

       }
       return max_length;
   }


}
