package graphs.cycle;

import java.util.*;


/*

For dfs(index):
    visited[index] = true
    curr_stack[index] = true

    For each neighbour:

        If curr_stack[neighbour] → cycle → return true

        Else if !visited[neighbour]:

        If dfs(neighbour) returns true → return true

        Else → ignore and continue

    curr_stack[index] = false

    Return false

 */

public class CourseSchedule1 {
    //DFS
    boolean visited[];
    boolean curr_stack[];

    public void formEdgeList(int num, int[][] prereq) {
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        List<Integer> nodes = new ArrayList<>();

        visited = new boolean[num];
        curr_stack = new boolean[num];

        /*{
        {empty}
        {}
        {}
        {}
        {}
        {}
         }*/
        for (int i = 0; i < num; i++) {
            edge.add(new ArrayList<>());
        }


        for (int[] req : prereq) {
            //req: [1,2]

            edge.get(req[1]).add(req[0]);

            //edge: {{0}, {1}, {1}, {6}, {2}, {3,4}

        }

        for (int i = 0; i < num; i++) {
            if (!visited[i]) {
                dfsTraversal(edge, i, visited, curr_stack);
            }
        }


    }

    public boolean dfsTraversal(ArrayList<ArrayList<Integer>> edge, int index, boolean visited[], boolean curr_stack[]) {
        visited[index] = true;
        curr_stack[index] = true;

        for (int neighbour : edge.get(index)) {

                if (curr_stack[neighbour]) {
                    return true;
                }
                else  if (!visited[neighbour]) {
                    if(dfsTraversal(edge, neighbour, visited, curr_stack))
                    {
                        return true;
                    }
                }
        }

          curr_stack[index] = false;

          return false;
    }
}