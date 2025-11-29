package arrays;

import java.util.*;

public class Anagram {
//    public boolean isAnagram(String s, String t) {
//        HashMap<Character, Integer> count = new HashMap<>();
//
//        for (int i = 0; i <= s.length(); i++) {
//            if (count.containsKey(s.charAt(i))) {
//                count.put(s.charAt(i), count.get(s.charAt(i) + 1));
//            }
//            count.put(s.charAt(i), 1);
//        }
//
//        for (int i = 0; i <= t.length(); i++) {
//            if (count.containsKey(t.charAt(i))) {
//                count.put(t.charAt(i), count.get(t.charAt(i)) - 1);
//            } else {
//                return false;
//            }
//            if (count.get(t.charAt(i)) == 0) {
//                count.remove(t.charAt(i));
//            }
//        }
//            if (count.size() == 0) {
//                return true;
//            } else {
//                return false;
//            }
//        }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> s_count = new HashMap<>();

        if(s.length()==0 && t.length()==0)
        {
            return true;
        }

        for(char c: s.toCharArray())
        {
            if(!s_count.containsKey(c))
            {
                s_count.put(c,1);
            }
            else
            {
                s_count.put(c, s_count.get(c)+1);
            }
        }

        for(char c: t.toCharArray()){
            HashMap<Character, Integer> t_count = new HashMap<>();
            if(s_count.containsKey(c))
            {
                s_count.put(c,s_count.get(c)-1);
            }
            else
            {
                return false;
            }
            if(s_count.get(c)==0)
            {
                s_count.remove(c);
            }
        }

        if(s_count.size() == 0)
        {
            return true;
        }
        return false;
    }

    }




