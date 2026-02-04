package files;
/*
Users who visited more than N times

Task: Given integer N=2, print userIds who visited more than N times.

Input file:

Google.com/a/:5
Fb.com/b/:5
X.com/c/:7
Google.com/d/:5
Fb.com/e/:3
X.com/f/:7
Google.com/g/:5


Expected output:

usersOver2Visits=[5]
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class NTimes {

    public static void calcFreq() throws IOException {
        int n = 2;

        FileReader fr = new FileReader("/Users/keerthanareddy/IdeaProjects/NC150/Solutions/src/files/inputFile.txt");
        BufferedReader br = new BufferedReader(fr);

        HashMap<Integer, Integer> freq = new HashMap<>();

        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            return;
        }

        while (line != null) {
            String[] parse_visit_count = line.split(":");

            if (parse_visit_count.length < 2) {
                line = br.readLine();
                continue;
            }

            int visit_id = Integer.parseInt(parse_visit_count[1].trim());


            if (!freq.containsKey(visit_id)) {
                freq.put(visit_id, 1);
            } else {
                freq.put(visit_id, freq.get(visit_id) + 1);
            }


            line = br.readLine();


        }
        br.close();


        for (int id : freq.keySet()) {
            if (freq.get(id) > n) {
                System.out.println(id);

            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        calcFreq();
    }
}
