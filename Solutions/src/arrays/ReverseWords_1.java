package arrays;

public class ReverseWords_1 {
    public String reverseWords(String s) {

        //remove trailing and leading spaces
        s = s.trim();

        //remove extra space: /s
        String[] split_string = s.split("\\s+");
        StringBuilder new_string = new StringBuilder();

        int len = split_string.length;

        for(int i=len-1; i>=0; i--)
        {
            new_string.append(split_string[i]);
            if(i>0)
            {
                new_string.append(" ");
            }
        }
        return new_string.toString();
    }
}
