package graphs.recurssion;

/*
    Queue : (row index, col index), time
    Add all rotten oranges to the Queue, time: 0

    remove from queue
     BFS neighbours
      if in bound & unvisited & fresh orange
        rotten the fresh orange
        add to queue
    */


import java.util.LinkedList;
import java.util.Queue;


public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int rowSize = grid.length;
        int colSize = grid[0].length;
        int maxTime = 0;

        // Add all rotten oranges first
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[]{row, col, 0});
                }
            }
        }

        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] current = queue.remove();

            int row = current[0];
            int col = current[1];
            int time = current[2];

            maxTime = Math.max(maxTime, time);

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rowSize &&
                        newCol >= 0 && newCol < colSize &&
                        grid[newRow][newCol] == 1) {

                    grid[newRow][newCol] = 2;
                    queue.add(new int[]{newRow, newCol, time + 1});
                }
            }
        }

        // Check if any fresh orange remains
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }

        return maxTime;
    }
}


