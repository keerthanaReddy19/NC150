package graphs.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/* BFS
First, scan the grid and enqueue all initially rotten oranges as starting points with time 0, marking them as visited since they are already rotten.

Use BFS to process the queue: for each orange removed, try all four directions (up, down, left, right).

Whenever a fresh orange is found that is not been visited, mark it visited, add it to the queue with time + 1, and continue the spread.

While traversing, keep track of the maximum time encountered, which represents the total minutes passed.

After BFS finishes, do one final pass over the grid to ensure no fresh orange was left unrotted (fresh but not visited).

If any such orange exists, return -1; otherwise, return the maximum time recorded
 */

public class RottenOranges {
    public int orangesRotting(int[][] grid)
    {
        int ans = 0;
        int col_size = grid[0].length;
        int row_size = grid.length;

        Queue<int[]> q = new ArrayDeque<>();
        boolean visited[][] = new boolean[row_size][col_size];

        for(int i = 0; i<row_size; i++)
        {
            for(int j = 0; j<col_size; j++)
            {
             if(grid[i][j]==2)
             {
                 q.add(new int[]{i, j,0});
                 visited[i][j] = true;
             }
            }
        }

        //BFS

        while(!q.isEmpty()) {
            //extract values
            int rotten_orange[] = q.poll();
            int r_index_i = rotten_orange[0];
            int r_index_j = rotten_orange[1];
            int time = rotten_orange[2];

            //track max_time
            ans = Math.max(ans, time);

            //extract neighbours

            if (r_index_i + 1 < row_size && !visited[r_index_i + 1][r_index_j] && grid[r_index_i + 1][r_index_j] == 1) {
                q.add(new int[]{r_index_i + 1, r_index_j, time + 1});
                //mark visited as true. Here, we aren't mutating the grid to rotten, just tracking the index. So, just the visited array is being tracked for rotten orange
                visited[r_index_i + 1][r_index_j] = true;

            }

            if (r_index_i - 1 >= 0 && !visited[r_index_i - 1][r_index_j] && grid[r_index_i - 1][r_index_j] == 1) {
                q.add(new int[]{r_index_i - 1, r_index_j, time + 1});
                visited[r_index_i - 1][r_index_j] = true;
            }

            if (r_index_j + 1 < col_size && !visited[r_index_i][r_index_j+1] && grid[r_index_i][r_index_j+1] == 1) {
                q.add(new int[]{r_index_i, r_index_j+1, time + 1});
                visited[r_index_i][r_index_j+1] = true;
            }


            if (r_index_j - 1 >= 0 && !visited[r_index_i][r_index_j-1] && grid[r_index_i][r_index_j-1] == 1) {
                q.add(new int[]{r_index_i, r_index_j-1, time + 1});
                visited[r_index_i][r_index_j-1] = true;
            }

        }

        //check for fresh orange
        for(int i = 0; i<row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }




       return ans; //time
    }
}
