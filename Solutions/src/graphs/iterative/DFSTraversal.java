package graphs.iterative;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DFSTraversal {
    public static void printDFS(Map<String, List<String>> graph, String src)
    {

     Stack<String> s = new Stack();
     s.push(src);

     while(!s.isEmpty())
     {
         String node = s.pop();
         List<String> values = graph.get(node);
         System.out.println(node);
         for (String neighbours: values)
         {
            s.push(neighbours);
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
        printDFS(graph, "a");

    }
}
