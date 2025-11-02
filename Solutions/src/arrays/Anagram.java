package arrays;

import java.util.HashMap;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i <= s.length(); i++) {
            if (count.containsKey(s.charAt(i))) {
                count.put(s.charAt(i), count.get(s.charAt(i) + 1));
            }
            count.put(s.charAt(i), 1);
        }

        for (int i = 0; i <= t.length(); i++) {
            if (count.containsKey(t.charAt(i))) {
                count.put(t.charAt(i), count.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
            if (count.get(t.charAt(i)) == 0) {
                count.remove(t.charAt(i));
            }
        }
            if (count.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
    }




