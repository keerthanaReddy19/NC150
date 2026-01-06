package graphs.bfs;

/*

visited[], distance[]

BFS + PriorityQueue<>();

initialize:
    distance[0] : 0
    distance[1]..distance[v] : infinity

pair class:
 node
 distance

pq.add(new pair(src, 0));

relaxation technique
  For (u, v):
   if (dist[u]+e.wt < dist[v]):
    then  dist[v] = dist[u] + e.wt;

 */

import graphs.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra_ShortestDistance {
    static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static int[] shortestDistance(ArrayList<Graph.Edge> graph[], int src) {
        int v = graph.length;
        int distance[] = new int[v];
        boolean visited[] = new boolean[v];
        int n = distance.length;
        distance[src] = 0;


        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.distance, p2.distance));

        //initialise each vertex distance to infinity in distance[]; except the first vertex (src)
        for (int i = 0; i < n; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            //remove from pq, check if visited, and loop through neighbours of vertex
            Pair curr_pair = pq.remove();
            int curr_node = curr_pair.node;

            //check if visited
            if (!visited[curr_node]) {
                visited[curr_node] = true;

                //loop through neighbours of each vertex
                for (int i = 0; i < graph[curr_node].size(); i++) {
                    Graph.Edge e = graph[curr_node].get(i);

                    int a = e.src;
                    int b = e.dest;
                    int wt = e.wt;


                    //relaxation technique to find shortest distance

                /* When a node is finally popped from the priority queue and marked visited,
                 its distance is guaranteed to be the shortest possible,
                 so we must never update it again */

                    if (!visited[b] && distance[a] + e.wt < distance[b]) {
                        distance[b] = distance[a] + e.wt;
                        pq.add(new Pair(b, distance[b]));
                    }

                }

            }
        }
        return distance;
    }

    public static void display(int[] distance) {
        for (int i = 0; i < distance.length; i++) {
            System.out.println(distance[i] + " ");

        }
    }

    public static void main(String[] args) {
        ArrayList<Graph.Edge> graph[] = new ArrayList[7];
        Graph.createGraph(graph);
        display(shortestDistance(graph, 0));
    }
}
