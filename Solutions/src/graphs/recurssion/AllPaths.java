package graphs.recurssion;

import graphs.Graph;

import java.util.ArrayList;

public class AllPaths {
    public static void DFSAllPaths(ArrayList<Graph.Edge> graph[], int target, String path, boolean visited[], int curr_node) {
        if (curr_node == target) {
            System.out.println(path);
            return;
        }

        visited[curr_node] = true;
        for (int i = 0; i < graph[curr_node].size(); i++) {
            Graph.Edge e = graph[curr_node].get(i);

            if (!visited[e.dest]) {

                DFSAllPaths(graph, target, path + "->" + e.dest, visited, e.dest);

            }
        }
        visited[curr_node] = false;
    }
}
