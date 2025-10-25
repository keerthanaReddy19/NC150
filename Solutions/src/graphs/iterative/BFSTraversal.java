package graphs.iterative;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSTraversal {

    public static void printBFS(Map<String, List<String>> graph, String src)
    {
        Queue<String> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty())
        {
            String node = q.remove();
            List<String> values = graph.get(node);
            System.out.println(node);
            for(String neighbour: values)
            {
                q.add(neighbour);
            }
        }
    }
    public static void main(String[] args)
    {
        Map<String, List<String>> graph = Map.of(
                "a", List.of("b", "c"),
                "b", List.of("d"),
                "c", List.of("e"),
                "d", List.of(),
                "e", List.of()
        );
        printBFS(graph, "a");

    }
}
