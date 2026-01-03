package graphs.iterative;

import graphs.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs_traversal(ArrayList<Graph.Edge> graph[], int v, int src) {
        boolean visited[] = new boolean[v];
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(src);

        while(!nodes.isEmpty())
        {
            int curr_node = nodes.remove();
            if(!visited[curr_node])
            {
            System.out.println(curr_node);
            visited[curr_node] = true;

            for(int i = 0; i< graph[curr_node].size(); i++)
            {
                Graph.Edge e = graph[curr_node].get(0);
                nodes.add(e.dest);
            }
            }
        }
        System.out.println();

    }
}
