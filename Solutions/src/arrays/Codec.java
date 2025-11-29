package arrays;

import java.util.*;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        String encoded = "";
        for(String s: strs)
        {
            encoded = encoded + s + "π";
            System.out.println(encoded);
        }

        List<String> decoded = decode(encoded);
        return encoded;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] orginal;
        List<String> answer = new ArrayList<>();
        if(s == null)
        {
            new ArrayList<>();
        }

        orginal = s.split("π",-1);
        for(int i=0;i<orginal.length-1;i++)
        {
            answer.add(orginal[i]);
        }
        return answer;
    }
}

