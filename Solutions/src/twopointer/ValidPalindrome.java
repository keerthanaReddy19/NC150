package twopointer;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        if(s==null)
        {
            return true;
        }

        s = s.toLowerCase();
        s = s.replaceAll("[^A-Za-z0-9]","");
        System.out.println(s);
        int len = s.length();



        int left = 0;
        int right = len-1;

        while(left<right)
        {
            if(!(s.charAt(left) == s.charAt(right)))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}
