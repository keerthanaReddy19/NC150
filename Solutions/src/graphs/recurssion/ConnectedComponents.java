package graphs.recurssion;


import java.util.*;

public class ConnectedComponents {

    public static int connectedComponentsCount(Map<Integer, List<Integer>> graph) {

        int count = 0;

        HashSet<Integer> visited = new HashSet<>();

        for(int node: graph.keySet())
        {
            if(traverse(graph, node, visited))
                count++;
        }



        return count;
    }

    public static boolean traverse(Map<Integer, List<Integer>> graph, int node, HashSet<Integer> visited)
    {

        if(visited.contains(node))
        {
            return false;
        }
        visited.add(node);

        for(int e: graph.getOrDefault(node, new ArrayList<>()))
        {
           traverse(graph, e, visited);
        }

        return true;
    }

    public static void main(String[] args)
    {

        Map<Integer, List<Integer>> graph = Map.of(
                0, List.of(8, 1, 5),
                1, List.of(0),
                5, List.of(0, 8),
                8, List.of(0, 5),
                2, List.of(3, 4),
                3, List.of(2, 4),
                4, List.of(3, 2)
        ); //2

     System.out.println(connectedComponentsCount(graph));




    }
}
