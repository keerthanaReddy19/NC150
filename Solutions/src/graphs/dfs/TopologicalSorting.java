package graphs.dfs;

import graphs.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
    public static void topoSortUtil(ArrayList<Graph.Edge> graph[], Stack s, boolean visited[], int curr)
    {
      visited[curr] = true;
      for(int i = 0; i< graph[curr].size(); i++)
      {
             Graph.Edge e = graph[curr].get(i);
             if(!visited[e.dest])
             {
                 topoSortUtil(graph, s, visited, e.dest);
             }
      }
      s.push(curr);
    }

    public static void topoSort(ArrayList<Graph.Edge> graph[]) {
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topoSortUtil(graph, s, visited, i);
            }
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop() + "");
        }
    }
        }


