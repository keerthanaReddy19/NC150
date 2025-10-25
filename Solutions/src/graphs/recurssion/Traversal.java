package graphs.recurssion;

import java.util.List;
import java.util.Map;

public class Traversal {

    public static void recurrsiveTraversal(Map<String, List<String>> graph, String src)
    {
        System.out.println(src);
        List<String> value = graph.get(src);
        for(String neighbours: value)
        {
            recurrsiveTraversal(graph, neighbours);
        }
    }

    public static void main(String args[])
    {
        Map<String, List<String>> graph = Map.of(
                "a", List.of("b", "c"),
                "b", List.of("d"),
                "c", List.of("e"),
                "d", List.of(),
                "e", List.of()
        );

        recurrsiveTraversal(graph, "a");


    }
}
