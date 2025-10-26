package graphs.recurssion;
import java.util.*;

public class HasPath {

    public static boolean PathExists(Map<String, List<String>> graph, String src, String dst) {


        if(src==dst)
        {
            return true;
        }

        for(String neighbour: graph.get(src))
        {
            if(PathExists(graph, neighbour, dst))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {

        Map<String, List<String>> graph = Map.of(
                "f", List.of("g", "i"),
                "g", List.of("h"),
                "h", List.of(),
                "i", List.of("g", "k"),
                "j", List.of("i"),
                "k", List.of()
        );

        System.out.println(PathExists(graph, "f", "k")); // true


    }



}
