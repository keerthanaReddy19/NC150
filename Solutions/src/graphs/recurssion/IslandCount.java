package graphs.recurssion;

import java.util.List;
import java.util.HashSet;
import java.util.AbstractMap.SimpleEntry;

class IslandCount {
    public static int checkIslandCount(List<List<String>> grid) {

        HashSet<SimpleEntry<Integer, Integer>> visited = new HashSet<>();
        int count = 0;
        for(int r = 0; r<grid.size(); r++)
        {
            for(int c =0 ; c<grid.get(0).size();c++)
            {
                if(explore(r, c, grid, visited)) {
                    count += 1;
                }

            }
        }
        return count;
    }

    public static boolean explore(int r, int c, List<List<String>> grid, HashSet<SimpleEntry<Integer, Integer>> visited) {

        boolean row_bound = r>=0 && r<grid.size();
        boolean col_bound = c>=0 && c<grid.get(0).size();

        if(!row_bound || !col_bound)
        {
            return false;
        }

        if(grid.get(r).get(c)=="W")
        {
            return false;
        }

        SimpleEntry<Integer, Integer> key = new SimpleEntry<>(r,c);
        if(visited.contains(key))
        {
            return false;
        }
        visited.add(key);

        explore(r + 1, c, grid, visited);
        explore(r - 1, c, grid, visited);
        explore(r, c + 1, grid, visited);
        explore(r, c - 1, grid, visited);



        return true;
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

        System.out.println(checkIslandCount(grid)); // -> 3

    }
}

