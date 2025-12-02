package arrays;

public class ReverseWords_2 {
    public void reverseWords(char[] s) {

        int len = s.length;
        int start = 0;

        //reverse whole arrat
        for (int i = len - 1; i > start; i--) {
            char temp = s[start];
            s[start] = s[i];
            s[i] = temp;
            start++;
        }
        System.out.println(s);

        //reverse each word
        int new_start = 0;
        for (int i = 0; i < len; i++) {

            if (s[i] == ' ' || i == len - 1) {
                int end;
                if (s[i] == ' ') {
                    end = i - 1;
                } else {
                    end = i;
                }


                while (new_start < end) {
                    char temp = s[new_start];
                    s[new_start] = s[end];
                    s[end] = temp;
                    new_start++;
                    end--;
                }
                new_start = i + 1;
            }

        }

    }
}
