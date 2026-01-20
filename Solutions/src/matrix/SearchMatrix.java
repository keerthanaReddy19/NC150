package matrix;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target){
        int row_size = matrix.length;
        int col_size = matrix[0].length;

        int row = row_size-1;
        int col = 0;

        while(row>=0 && col<col_size)
        {
            if(matrix[row][col]>target)
            {
                row--;
            }
            else if(matrix[row][col]<target)
            {
                col++;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
