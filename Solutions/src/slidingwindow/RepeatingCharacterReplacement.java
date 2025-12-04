package slidingwindow;

import java.util.*;

public class RepeatingCharacterReplacement {
    public int characterReplacement(String s, int k)
    {

        HashMap<Character, Integer> seen_list = new HashMap<>();
        int left = 0;
        int max_length = 0;
        int characters_to_be_changed = 0;
        int max_freq = 0;
        int window_size = 0;

        for(int right =0; right<s.length();right++)
        {
            seen_list.put(s.charAt(right), seen_list.getOrDefault(s.charAt(right),0)+1);
            max_freq  = Math.max(max_freq,seen_list.get(s.charAt(right)));
            window_size = right - left + 1;

            while(window_size - max_freq > k)
            {

                seen_list.put(s.charAt(left), seen_list.get(s.charAt(left))-1);
                left++;
                window_size = right - left + 1;
            }

        }
        max_length = Math.max(max_length, window_size);

        return max_length;
    }
}
