package graphs.recurssion;

import java.util.HashMap;
import java.util.*;

public class UndirectedPath {

    public static boolean undirectedPath(List<List<String>> edges, String nodeA, String nodeB) {


        /*
        create a hashmap of the edges list as it is un-directional have mapping for each of the elements in sublist, mapping to the corresponding element.
        example : list - { {b,c} } here, have b->c and c->b mapping
         */

        HashMap<String, List<String>> hm = new HashMap<>();

        for(List<String> edge: edges)
        {
            String a = edge.get(0);
            String b = edge.get(1);

            if(!hm.containsKey(a))
            {
                hm.put(a, new ArrayList());
            }

            if(!hm.containsKey(b))
            {
                hm.put(b, new ArrayList());
            }

            hm.get(a).add(b);
            hm.get(b).add(a);

        }


        boolean answer = hasPath(hm, nodeA, nodeB, new HashSet<>());

        return answer;

    }

    public static boolean hasPath(HashMap<String, List<String>> hm, String src, String dest, HashSet<String> visited)
    {
        if(src == dest)
        {
            return true;
        }

        if(visited.contains(src))
        {
            return false;
        }

        visited.add(src);

        for(String e: hm.getOrDefault(src, new ArrayList<>()))
        {
           if(hasPath(hm, e, dest, visited))
           {
               return true;
           }
        }
        return false;


    }





    public static void main(String[] args)
    {

        List<List<String>> edges = List.of(
                List.of("i", "j"),
                List.of("k", "i"),
                List.of("m", "k"),
                List.of("k", "l"),
                List.of("o", "n")
        );


        System.out.println(undirectedPath(edges, "j", "m"));

    }

}
