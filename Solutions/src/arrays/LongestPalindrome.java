package arrays;
//LC 5
public class LongestPalindrome {

    public String longestPalindromeSubString(String s) {

        if(s==null || s.length() == 0)
        {
            return null;
        }
        int length = s.length();

        int start = 0;
        int end = 0;


        for(int i=0; i<length; i++)
        {
            int even = search(i, i, s);
            int odd = search(i, i+1, s);
            int max_length = Math.max(even,odd);

            //Left gets (len−1)/2, right gets len/2 — integer division handles odd v/s even.
            if (max_length > end - start + 1) {
                start = i - (max_length - 1) / 2;
                end   = i + max_length / 2;
            }

        }

        return s.substring(start, end+1);
    }

    public int search(int left_index, int right_index, String s)
    {

        while(left_index>=0 && right_index<s.length() &&
                s.charAt(left_index)==s.charAt(right_index))

        {

            left_index = left_index-1;
            right_index = right_index+1;

        }

        return right_index - left_index - 1;

    }
}

