package graphs.dfs;

import graphs.Graph;

import java.util.ArrayList;

public class CycleDetection {
    public static boolean isCycleDetected(ArrayList<Graph.Edge> graph[], boolean visited[], boolean occurance[],  int curr)
    {
        /*
        visited[] tells us a node has been seen at some point.

        occurrence[] tells us a node is on the current DFS path.

        A cycle exists only if we reach a node that is already in the current path, not just visited before.

        Hence, we need two arrays to distinguish seen earlier from still in recursion stack.
         */
        visited[curr] = true;
        occurance[curr] = true;

        for(int i =0; i< graph[curr].size(); i++)
        {
            Graph.Edge e = graph[curr].get(i);
            int dest = e.dest;

            if(!visited[dest])
            {
                if(isCycleDetected(graph, visited, occurance, dest)) {
                    return true;
                }
            }
            else if(occurance[dest])
            {
                return true;
            }

        }
        occurance[curr] = false;

        return false;
    }

    public static boolean isCycle(ArrayList<Graph.Edge> graph[])
    {
        boolean visited[] = new boolean[graph.length];
        boolean occurance[] = new boolean[graph.length];

        for(int i =0; i<graph.length;i++)
        {
            if(visited[i]==false)
            {
                boolean cycle = isCycleDetected(graph, visited, occurance, i);
                if(cycle)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
