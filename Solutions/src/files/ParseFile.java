package files;

import java.io.*;
import java.util.*;



/*
Google.com/kjkr/:5
Fb.com/rkrj/:3
Google.com/abc/:5
X.com/home/:7
X.com/pp/:7
X.com/pp/:7

-number of unique users
-the top 2 users by number of visits (most lines)


 */

public class ParseFile {

//    public static void readFile() throws IOException {
//
//        //HashSet to store unique users
//        HashSet<String> unique_users = new HashSet<>();
//        HashMap<String, Integer> freq_visits = new HashMap<String, Integer>();
//
//
//        //Read File
//        FileReader fr = new FileReader("/Users/keerthanareddy/IdeaProjects/NC150/Solutions/src/files/inputFile.txt");
//        BufferedReader br = new BufferedReader(fr);
//        String line = br.readLine();
//
//        if(line == null)
//        {
//            System.out.println("Empty File");
//            return;
//        }
//
//        while(line!=null)
//        {
//            String[] parse = line.split("/");
//            if(parse.length<2) {
//                line = br.readLine();
//                continue;
//            }
//                String user = parse[1];
//                unique_users.add(user);
//
//                if (!freq_visits.containsKey(user)) {
//                    freq_visits.put(user, 1);
//                } else {
//                    freq_visits.put(user, freq_visits.get(user) + 1);
//                }
//            line = br.readLine();
//        }
//        br.close();
//
//
//        System.out.println("Number of unique users: "+unique_users.size());
//
//            //Top 2 visitors
//            int max_count_1 = Integer.MIN_VALUE;
//            String top_1 = null;
//
//            int max_count_2 = Integer.MIN_VALUE;
//            String top_2 = null;
//
//            for(String visitor: freq_visits.keySet())
//            {
//                 if(freq_visits.get(visitor)>max_count_1)
//                 {
//                     max_count_2 = max_count_1;
//                     top_2 = top_1;
//
//                     max_count_1 = freq_visits.get(visitor);
//                     top_1 = visitor;
//                 }
//                 else if(freq_visits.get(visitor)>max_count_2 && freq_visits.get(visitor)<max_count_1)
//                 {
//                     max_count_2 = freq_visits.get(visitor);
//                     top_2 = visitor;
//                 }
//        }
//
//            System.out.println("Top 1 user:");
//            for(String find_match: freq_visits.keySet())
//            {
//                if(max_count_1 == freq_visits.get(find_match))
//                {
//                    System.out.println(find_match);
//                }
//            }
//
//            if(max_count_2==Integer.MIN_VALUE)
//            {
//                System.out.println("No top2 found");
//            }
//            else {
//                System.out.println("Top 2 user:");
//                for (String find_match : freq_visits.keySet()) {
//                    if (max_count_2 == freq_visits.get(find_match)) {
//                        System.out.println(find_match);
//                    }
//                }
//
//            }
//
//
//    }
    static ArrayList<String> result = new ArrayList<>();
    public static void readFile() throws IOException {
        int k = 2;
        result.clear();
        try {
            FileReader fr = new FileReader("/Users/keerthanareddy/IdeaProjects/NC150/Solutions/src/files/inputFile.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            if (line == null) {
                System.out.println("Empty File");
                return;
            }

            HashMap<String, Integer> track_users = new HashMap<>();
            PriorityQueue<String> pq = new PriorityQueue<>(
                    (a, b) ->
                    {
                        int comp = Integer.compare(track_users.get(b), track_users.get(a));
                        if (comp != 0)
                            return comp;
                        else
                            return a.compareTo(b);
                    });

            while (line != null) {
                if(line.trim().isEmpty())
                {
                    line = br.readLine();
                    continue;
                }
                String[] parse_users = line.split("/");
                if (parse_users.length < 2) {
                    line = br.readLine();
                    continue;
                }
                String user = parse_users[1];


                if (!track_users.containsKey(user)) {
                    track_users.put(user, 1);
                } else {
                    track_users.put(user, track_users.get(user) + 1);
                }

                line = br.readLine();
            }

            br.close();


            for (String user : track_users.keySet()) {
                pq.add(user);
            }

            int count = 0;
            while (!pq.isEmpty() && count < k) {

                result.add(pq.remove());
                System.out.println(result);
                count++;
            }
            if (count < k) {
                System.out.println("No values");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }




    public static void main(String[] args) throws IOException {
        readFile();
        ArrayList<String> test_result = new ArrayList<>();
        test_result.add("kjkr");
        test_result.add("rkrj");

       if(test_result.equals(result))
       {
           System.out.println("Test 1 Success");

       }
       else
       {
           System.out.println("Test 1 Failed");
       }
    }
}










