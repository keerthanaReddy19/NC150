package graphs.recurssion;

import java.util.List;

public class MinIsland {
   /* public static int checkIslandCount(List<List<String>> grid) {

        HashSet<AbstractMap.SimpleEntry<Integer, Integer>> visited = new HashSet<>();
        int count_island = Integer.MAX_VALUE;
        for(int r = 0; r<grid.size(); r++)
        {
            for(int c =0 ; c<grid.get(0).size();c++)
            {
                int size = explore(r, c, grid, visited);

                if(size>0)
                    count_island = Math.min(count_island, size);
            }
        }
        return count_island;
    }

    public static int explore(int r, int c, List<List<String>> grid, HashSet<AbstractMap.SimpleEntry<Integer, Integer>> visited) {

        boolean row_bound = r>=0 && r<grid.size();
        boolean col_bound = c>=0 && c<grid.get(0).size();

        if(!row_bound || !col_bound)
        {
            return 0;
        }

        if(grid.get(r).get(c)=="W")
        {
            return 0;
        }

        AbstractMap.SimpleEntry<Integer, Integer> key = new AbstractMap.SimpleEntry<>(r,c);
        if(visited.contains(key))
        {
            return 0;
        }
        visited.add(key);

        int count = 1;
        count+= explore(r + 1, c, grid, visited);
        count+=  explore(r - 1, c, grid, visited);
        count+= explore(r, c + 1, grid, visited);
        count+= explore(r, c - 1, grid, visited);




        return count;
    } */
   public static int checkIslandCount(List<List<String>> grid) {
       int rows = grid.size();
       int cols = grid.get(0).size();
       int size = 0;
       int count_island = Integer.MAX_VALUE;;
       boolean[][] visited = new boolean[rows][cols];

       for(int r = 0; r<rows; r++)
       {
           for(int c =0 ; c<cols; c++)
           {
               if(grid.get(r).get(c) == "L")
               {
                    size = explore(grid,r,c, visited);
               }
               if(size>0)
                   count_island = Math.min(count_island, size);
           }
   }
       return count_island;
   }

    public static int  explore( List<List<String>> grid, int r, int c, boolean[][] visited) {
       if(r<0 || c<0 ||  r >= grid.size() ||  c >= grid.get(0).size() || grid.get(r).get(c) == "W")
       {
           return 0;
       }

        if (visited[r][c] || "W".equals(grid.get(r).get(c)))
            return 0;
        visited[r][c] = true;


         int count = 1;
        count+=explore(grid, r+1, c, visited);
        count+=explore(grid, r, c+1, visited);
        count+=explore(grid, r-1, c, visited);
        count+=explore(grid, r, c-1, visited);

        return count;
    }

        public static void main(String args[]) {

        List<List<String>> grid = List.of(
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "L", "W"),
                List.of("W", "W", "L", "L", "W"),
                List.of("L", "W", "W", "L", "L"),
                List.of("L", "L", "W", "W", "W")
        );

        System.out.println(checkIslandCount(grid)); // -> 2

    }
}
