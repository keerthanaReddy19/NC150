package arrays;

public class PalindromicSubstring {
    public int countSubstrings(String s) {

        int len = s.length();
        int count = 0;

        for(int i=0; i<len; i++)
        {
            count+=checkSubString(s, i, i);
            count+=checkSubString(s, i, i+1);
        }
        return count;
    }

    int checkSubString(String s, int left, int right)
    {
        int count = 0;
        while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right))
        {
            count++;
            left  = left-1;
            right = right+1;
        }
        return count;
    }
}
