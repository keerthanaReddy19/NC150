package matrix;

public class SetZeros {
    public void setZeroes(int[][] matrix) {
        Boolean isCol = false;

        int row_size = matrix.length;
        int col_size = matrix[0].length;

        for(int i=0;i<row_size;i++)
        {
            if(matrix[i][0]==0)
            {
                isCol = true;
            }

            for(int j = 1; j<col_size;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < row_size; i++) {
            for (int j = 1; j < col_size; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0]==0)
        {
            for(int j=0;j<col_size;j++)
            {
                matrix[0][j] = 0;
            }
        }

        if(isCol)
        {
            for(int i=0;i<row_size;i++)
            {
                matrix[i][0] = 0;
            }
        }

    }
}
