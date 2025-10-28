package graphs.recurssion;
import java.util.*;

public class ShortestPath {
    public static int shortestPathDist(List<List<String>> edges, String nodeA, String nodeB) {

        HashMap<String, List<String>> hm = buildMap(edges);
        HashSet<String> visited = new HashSet<>();
        Queue<Map.Entry<String, Integer>> q = new LinkedList<>();

        q.add(Map.entry(nodeA, 0));
        visited.add(nodeA);
        while(!q.isEmpty())
        {
            Map.Entry<String, Integer> node_data = q.poll();

            String node = node_data.getKey();
            int distance = node_data.getValue();

            if(node == nodeB)
            {
                return distance;
            }

            for(String neighbour: hm.get(node))
            {
                if(!visited.contains(neighbour))
                {
                    q.add(Map.entry(neighbour, distance+1));
                    visited.add(neighbour);
                }
            }
        }
        return -1;

    }
    public static HashMap<String, List<String>> buildMap(List<List<String>> edges)
    {
        HashMap<String, List<String>> hm = new HashMap<>();

        for(List<String> edge: edges)
        {
            String a = edge.get(0);
            String b = edge.get(1);

            if(!hm.containsKey(a))
            {
                hm.put(a, new ArrayList<>());
            }

            if(!hm.containsKey(b))
            {
                hm.put(b, new ArrayList<>());
            }

            hm.get(a).add(b);
            hm.get(b).add(a);

        }
        return hm;
    }

    public static void main(String[] args)
    {

        List<List<String>> edges = List.of(
                List.of("w", "x"),
                List.of("x", "y"),
                List.of("z", "y"),
                List.of("z", "v"),
                List.of("w", "v")
        );

        System.out.println(shortestPathDist(edges, "w", "z")); // -> 2



    }

}
