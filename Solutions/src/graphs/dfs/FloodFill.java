package graphs.dfs;

/*
 LC 733

Approach: DFS
O(m * n)
 */

public class FloodFill {
    private int row_size;
    private int col_size;
    int sr_color;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        row_size = image.length;
        col_size = image[0].length;
        sr_color = image[sr][sc];

        DfsFill(image, sr, sc, color);

        return image;

    }

    public void DfsFill(int[][] image, int sr, int sc, int color) {
        if (sr < 0 || sr >= row_size || sc < 0 || sc >= col_size) {
            return;
        }

        if (image[sr][sc] == color) {
            return;
        }

        if (image[sr][sc] == sr_color) {

            image[sr][sc] = color;

            DfsFill(image, sr + 1, sc, color);
            DfsFill(image, sr - 1, sc, color);
            DfsFill(image, sr, sc + 1, color);
            DfsFill(image, sr, sc - 1, color);
        }

        return;
    }
}
