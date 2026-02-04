package files;
/*
Unique users per page

I/p:
Google.com/kjkr/:5
Google.com/kjkr/:5
Google.com/kjkr/:3
Fb.com/rkrj/:3
Fb.com/rkrj/:7
Fb.com/rkrj/:7

O/p:
Google.com/kjkr/ uniqueUsers=2
Fb.com/rkrj/ uniqueUsers=2

Google.com/kjkr/  5,3
Fb.com/rkrj/      3,7





 */

import java.io.*;
import java.util.*;

public class UniqueUsers {
  public static void uniqueUserCount() throws IOException {
      FileReader fr = new FileReader("/Users/keerthanareddy/IdeaProjects/NC150/Solutions/src/files/inputFile.txt");
      BufferedReader br = new BufferedReader(fr);
      HashMap<String, Set<String>> users = new HashMap<>();

      //ArrayList<String> result = new ArrayList<>();

      String line = br.readLine();

      if (fr == null || line == null || line.trim().isEmpty()) {
          return;
      }

      while (line != null) {
          String[] parse = line.split(":");
          String user = parse[0];
          String visitID = parse[1];

          if(!users.containsKey(user)) {
              users.put(user, new HashSet<>());
              users.get(user).add(visitID);
          }
          else
          {
              users.get(user).add(visitID);
          }
          line = br.readLine();
          }


          br.close();




      for (String s : users.keySet()) {

         System.out.print(s + " ");
         System.out.println("Unique Users: " +users.get(s).size());

      }
  }

  public static void main(String[] args) throws IOException
  {
      uniqueUserCount();
  }

}
