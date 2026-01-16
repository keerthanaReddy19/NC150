package arrays;
//LC 3
import java.util.HashSet;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s)
    {
        if(s.length()==0)
        {
            return 0;
        }

        int length = s.length();
        int left = 0;
        int max_len = 0;

        HashSet<Character> seen_list = new HashSet<>();

        for(int right =0; right<length;right++)
        {
            while(seen_list.contains(s.charAt(right)))
            {
                seen_list.remove(s.charAt(left));
                left++;
            }
            seen_list.add(s.charAt(right));
            max_len = Math.max(max_len, right-left+1);
        }
             return max_len;
    }
}
