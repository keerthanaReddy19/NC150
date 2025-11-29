package arrays;
import java.util.*;
/*
    groupAnagrams(strs):

    Create a map freq  // key = frequency signature, value = list of words

    For each word in strs:
        signature = getFreqString(word)  // unique representation of letter counts

        If signature already in map:
            append word to its list
        Else:
            create new list with that word and put into map

    return all value lists from freq map
*/


/*
    getFreqString(str):

    Create integer array count[26] initialized to 0
    // 26 → fixed space to count all letters 'a' to 'z'

    For each character ch in str:
        increment count[ch - 'a']

    Now build a signature string describing frequency of ALL letters
    (even if some have count 0)

    Let c = 'a'
    For each number x in count array:
        append c and append x to signature
*/

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> group = new HashMap<>();

      for(String s: strs)
      {
          String freq_key = getFreqString(s);
          if(!group.containsKey(freq_key))
          {
              List<String> str_list  = new ArrayList<>();
              str_list.add(s);
              group.put(freq_key, str_list);
          }
          else
          {
             group.get(freq_key).add(s);
          }
    }
      return new ArrayList<>(group.values());
    }

    private String getFreqString(String s) {
        char[] freq = new char[26];

        for(char ch : s.toCharArray())
        {
            freq[ch - 'a']++;

        }

        //Build string
        StringBuilder freq_string = new StringBuilder("");

        char c1 = 'a';
        for(int i: freq)
        {
            freq_string.append(c1);
            freq_string.append(i);
            c1++;
        }
        return freq_string.toString();
    }
}
