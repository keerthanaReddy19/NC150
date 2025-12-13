package slidingwindow;
/*

Input: s1 = "ab", s2 = "eidbaooo"


 char freq_s1[] of 26 : Store freq of each char in string s1

 Here length of s1 string will be the window size in s2.

 s2 window size: s1.length;
 left: 0;
 right: s1.length;
 char freq_s2[] for each window.
 check freq_s2[] of each window matches with freq_s1[]

 */
public class StringPermutation {
    public boolean checkInclusion(String s1, String s2)
    {
        if (s1.length() > s2.length()) {
            return false;
        }
        char[] s1_freq = new char[26];

        for(char c: s1.toCharArray())
        {
            s1_freq[c - 'a']++;
        }

        int s1_length = s1.length();

        //iterate through the window size s1_length
        for(int i = 0; i<s2.length();i++) {
            int j = i;
            int count = 0;
            char[] s2_ifreq = new char[26];
            while (count < s1.length() && j<s2.length())
            {
                s2_ifreq[s2.charAt(j) - 'a']++;
                j++;
                count++;
            }
            if (freqMatch(s1_freq, s2_ifreq)) {
                return true;
            }
        }

        return false;
    }

    private boolean freqMatch(char[] s1_freq, char[] s2_ifreq)
    {
        for(int i =0;i<26;i++)
        {
            if(s1_freq[i]!=s2_ifreq[i])
            {
                return false;
            }
        }
        return true;
    }
}
