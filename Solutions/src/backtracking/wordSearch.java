package backtracking;
/*
LC 79

/*
LC 79 (Word Search)

Fail fast (return false) if:
- out of bounds
- already visited
- board[r][c] != word.charAt(i)

If valid (unvisited + char matches):
- mark visited = true
- search neighbors (up/down/left/right) for i+1
- mark visited = false (backtrack, always undo)

Success base case:
- if i == word.length() return true

TC (worst case): O(m * n * 4^L)   // m,n = board dims, L = word length
SC: O(L) recursion (or O(m*n) including visited array)
*/

public class wordSearch {
    private int row_size;
    private int col_size;
    private String words;

    public boolean exist(char[][] board, String word)
    {

        if(board == null || board.length==0)
        {
            return false;
        }


        row_size = board.length;
        col_size = board[0].length;
        words = word;

        boolean visited[][] = new boolean[row_size][col_size];


        for(int row = 0; row<row_size; row++)
        {
            for(int col = 0; col<col_size; col++)
            {
                if(dfsBacktrack(board, 0, row, col, visited))
                {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean dfsBacktrack(char[][] board, int word_index, int row_index, int col_index, boolean visited[][])
    {
        if(word_index>=words.length())
        {
            return true;
        }
        if(row_index>=row_size || col_index>=col_size || row_index<0 || col_index<0)
        {
            return false;
        }

        if(visited[row_index][col_index] || board[row_index][col_index]!=words.charAt(word_index))
        {
            return false;
        }

        visited[row_index][col_index] = true;

        word_index = word_index +1;
        boolean found  = dfsBacktrack(board, word_index, row_index+1, col_index, visited) ||
                dfsBacktrack(board, word_index, row_index, col_index+1, visited) ||
                dfsBacktrack(board, word_index, row_index-1, col_index, visited) ||
                dfsBacktrack(board, word_index, row_index, col_index-1, visited);

        visited[row_index][col_index] = false;


        return found;
    }
}