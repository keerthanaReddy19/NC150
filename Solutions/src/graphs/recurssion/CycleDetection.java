package graphs.recurssion;
import graphs.Graph;
import java.util.ArrayList;

public class CycleDetection {
    public static boolean isCycleDetected(ArrayList<Graph.Edge> graph[], boolean visited[], boolean occurance[],  int curr)
    {
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
}
