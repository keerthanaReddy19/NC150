package graphs.connectedcomponents;

import java.util.*;

public class LargestComponent {
    public static int largestComponent(Map<Integer, List<Integer>> graph) {
        int count = 0;
        int max_count = 0;

        HashSet<Integer> visited = new HashSet<>();
        for(int node: graph.keySet())
        {
            max_count = Math.max(max_count, traverse(graph, node, visited));
        }
        return max_count;
    }

    public static int traverse(Map<Integer, List<Integer>> graph, int node, HashSet<Integer> visited)
    {
        if(visited.contains(node))
        {
            return 0;
        }

        visited.add(node);

        int size = 1;

        for(int neighbour: graph.getOrDefault(node, new ArrayList<>()))
        {

            size += traverse(graph, neighbour, visited);

        }

        return size;
    }

    public static void main(String[] args)
    {

        Map<Integer, List<Integer>> graph =
                Map.of(
                        0, List.of(8, 1, 5),
                        1, List.of(0),
                        5, List.of(0, 8),
                        8, List.of(0, 5),
                        2, List.of(3, 4),
                        3, List.of(2, 4),
                        4, List.of(3, 2)
                );

        System.out.println(largestComponent(graph)); //4




    }
}
