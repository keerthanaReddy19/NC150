package arrays;

import java.util.HashSet;

/*
  - Traverse each cell and validate 3 rules:
      1) No duplicate in the current row
      2) No duplicate in the current column
      3) No duplicate in the corresponding 3x3 box

  - Reuse one HashSet for rows + one for columns, cleared each iteration
  - Use an array of 9 HashSets for boxes (since box filling is not sequential)
    → box index = (row / 3) * 3 + (col / 3)

  - Skip '.' since it represents an empty cell

*/

public class ValidSuduko {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character> row_val = new HashSet<>();
        HashSet<Character> col_val = new HashSet<>();
        HashSet<Character>[] box_val = new HashSet[9];
        int box_index;

        for(int r = 0; r<9;r++)
        {
            for(int c = 0; c<9;c++) {
                //reset for every row, col
                row_val.clear();
                col_val.clear();

                //row check
                if (board[r][c] != '.' && row_val.contains(board[r][c])) {
                    return false;
                } else {
                    row_val.add(board[r][c]);
                }


                //col_check
                if (board[r][c] != '.' && col_val.contains(board[r][c])) {
                    return false;
                } else {
                    col_val.add(board[r][c]);
                }


                //box_check
                box_index = (r / 3) * 3 + (c / 3);
                if (board[r][c] != '.' && box_val[box_index].contains(board[r][c])) {
                    return false;
                } else {
                    box_val[box_index].add(board[r][c]);
                }

            }
        }
        return true;

    }
}
