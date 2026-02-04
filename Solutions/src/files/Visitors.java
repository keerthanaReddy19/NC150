package files;
/*
google.com/home=user1
google.com/home=user2
google.com/about=user1
fb.com/login=user3
fb.com/login=user1
amazon.com/cart=user2
amazon.com/cart=user2

The list of unique users who visited any page.
The top 2 pages that were visited the most.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Visitors {

    public static void parse() throws IOException {
        int k = 2;
        BufferedReader br = new BufferedReader(new FileReader("/Users/keerthanareddy/IdeaProjects/NC150/Solutions/src/files/accessLog.txt"));
        String line = br.readLine();

        HashSet<String> users = new HashSet<>();
        HashMap<String, Integer> freq = new HashMap<>();
        PriorityQueue<String> top_visit = new PriorityQueue<>(

                (a,b) ->
                {

                    int result = Integer.compare(freq.get(b), freq.get(a));
                    if(result!=0)
                        return result;
                    else
                        return a.compareTo(b);
                }

        );


        while(line!=null)
        {
            String[] parse = line.trim().split("\\/");
            String[] parse_user = parse[1].trim().split("\\=");
            String page = parse[0];
            String user = parse_user[1];


            //unique users
            users.add(user);

            //freq tracker
            freq.put(page, freq.getOrDefault(page, 0)+1);

            line = br.readLine();
        }

        for(String page_name: freq.keySet())
        {
            top_visit.add(page_name);
        }

        int count = 0;
        while(!top_visit.isEmpty() && count<k)
        {
            System.out.println(top_visit.remove());
            count++;
        }

        for(String s: users)
        {
            System.out.println(s);
        }

    }



    public static void main(String[] args) throws IOException {
        parse();
    }
}
