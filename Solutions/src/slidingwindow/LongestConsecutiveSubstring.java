package slidingwindow;

/*
HashSet: characters in String
Track max_length on each iteration
 - right-left+1
if character is already present in hashset,
remove the left char from hashset until the repeated char is removed!

Intuition:
In sliding window problems, left and right always mark a valid inclusive window.
As right expands, the window grows; as left moves, the window shrinks.
Since both ends are included, the window length is right - left + 1.
We update the answer only when the window satisfies the constraint.
right - left counts how far apart the indices are; +1 includes the starting index itself.
 */

import java.util.HashSet;

public class LongestConsecutiveSubstring {

//   public int lengthOfLongestSubstring(String s)
//   {
//       if (s.length() == 0) {
//           return 0;
//       }
//       HashSet<Character> seen_list = new HashSet<>();
//       int left = 0;
//       int max_length = 0;
//       for(int right =0; right<s.length();right++)
//       {
//           while(seen_list.contains(s.charAt(right)))
//           {
//              seen_list.remove(s.charAt(left));
//              left++;
//           }
//           seen_list.add(s.charAt(right));
//           max_length = Math.max(max_length, right-left+1);
//
//       }
//       return max_length;
//   }

    //revisit

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max_length = 0;
        HashSet<Character> seen_list = new HashSet<>();

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            while (seen_list.contains(s.charAt(right))) {
                seen_list.remove(s.charAt(left));
                left++;
            }
            seen_list.add(s.charAt(right));
            max_length = Math.max(max_length, right - left + 1);

        }

        return max_length;
    }


}
