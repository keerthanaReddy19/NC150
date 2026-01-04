package graphs.dfs;

import graphs.Graph;

import java.util.ArrayList;

/*
In an undirected graph, a cycle exists if DFS finds a visited neighbor that is not the parent.

For every neighbor:

If the neighbor is visited and is the parent, ignore it
→ this is just the edge we came from.

If the neighbor is visited and NOT the parent,
→ we found a back edge ⇒ cycle exists.

If the neighbor is not visited, DFS into it, passing curr as the new parent.
 */

public class CycleDetectionUndirected {
    public static boolean detectCycle(ArrayList<Graph.Edge> graph[], boolean visited[], int curr, int parent)
    {
        visited[curr] = true;

        for(int i = 0; i<graph[curr].size(); i++)
        {
            Graph.Edge e  = graph[curr].get(i);
            //case 1: if visited, and parent
            if(visited[e.dest] && e.dest == parent)
            {
                continue;
            }

            //case 2: if visited, and not a parent
            else if(visited[e.dest] && e.dest!=parent)
            {
                return true;
            }

            //case 3: if not visited
            else
            {
                boolean isCycle = detectCycle(graph, visited, e.dest, curr);
                if(isCycle)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(ArrayList<Graph.Edge> graph[])
    {
        boolean visited[] = new boolean[graph.length];
        for(int i =0; i<graph.length;i++)
        {
            if(!visited[i]) {
                boolean detected = detectCycle(graph, visited, i, -1);

                if (detected) {
                    return true;
                }
            }
        }
        return false;
    }
}
