package arrays;

/*
        e    o    e
        1 -> 2    3
                  !
      o 4  e 5  o 6
        !
      e 7  o 8 <- 9 e

 */

/*
Step 1: add first element to result array;
 */
public class DiagonalMatrix {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        if(mat==null || mat.length == 0)
        {
            return new int[0];
        }

        int[] result = new int[m*n];
        int row = 0, col = 0;

        for(int i =0;i <m*n; i++)
        {
            result[i] = mat[row][col];

            if((row+col)%2 == 0) {
                if (col == n - 1) {
                    row++;
                }
                else if (row == 0) {
                    col++;
                }else {
                    row--;
                    col++;
                }
            }
            else
            {
                if(row==m-1)
                {
                    col++;
                }
                else if(col==0)
                {
                    row++;
                }
                else
                {
                    col--;
                    row++;
                }
            }
        }

        return result;
    }

}
