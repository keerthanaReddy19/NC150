package graphs;
import java.util.*;

import static graphs.recurssion.AllPaths.DFSAllPaths;

public class Graph {
    public static class Edge
    {
        public int src;
        public int dest;
        public  int wt;

        public Edge(int src, int dest, int wt)
        {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

   public static void createGraph(ArrayList<Edge> graph_nodes[]) {
        //for each vertex, have a arraylist that contains the information of edges(pair) of type edge
        for (int i = 0; i < graph_nodes.length; i++) {
            graph_nodes[i] = new ArrayList<>();
        }

        graph_nodes[0].add(new Edge(0, 1, 1));
        graph_nodes[0].add(new Edge(0, 2, 1));

        graph_nodes[1].add(new Edge(1, 0, 1));
        graph_nodes[1].add(new Edge(1, 3, 1));

        graph_nodes[2].add(new Edge(2, 0, 1));
        graph_nodes[2].add(new Edge(2, 4, 1));

        graph_nodes[3].add(new Edge(3, 1, 1));
        graph_nodes[3].add(new Edge(3, 4, 1));
        graph_nodes[3].add(new Edge(3, 5, 1));

        graph_nodes[4].add(new Edge(4, 2, 1));
        graph_nodes[4].add(new Edge(4, 3, 1));
        graph_nodes[4].add(new Edge(4, 5, 1));

        graph_nodes[5].add(new Edge(5, 3, 1));
        graph_nodes[5].add(new Edge(5, 4, 1));
        graph_nodes[5].add(new Edge(5, 6, 1));

        graph_nodes[6].add(new Edge(6, 5, 1));


    }




    public static void main(String[] args)
    {
        //vertices
        int v = 7;
        ArrayList<Edge> graph_nodes[] = new ArrayList[v];
        boolean visited[] = new boolean[v];
        createGraph(graph_nodes);
        String path = " ";
        DFSAllPaths(graph_nodes, 5, "0", visited, 0);
    }
}
