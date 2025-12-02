package arrays;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> track_occurance = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                track_occurance.push(')');
            } else if (s.charAt(i) == '{') {
                track_occurance.push('}');
            } else if (s.charAt(i) == '[') {
                track_occurance.push(']');
            } else {
                if (track_occurance.isEmpty() || track_occurance.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        return track_occurance.isEmpty();
    }
}
