package graphs.recurssion;

import java.util.Arrays;

public class FloodFill {
    public static int[][] fillColor(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc]==color)
        {
            return image;
        }
        else
        {
            int curr_color = image[sr][sc];


            helper(image, sr, sc, color, curr_color);
        }

        return image;
    }

    private static void helper(int[][] image, int sr, int sc, int color, int curr_color) {
        int r = image.length;
        int c = image[0].length;

        if(sr<0 || sc<0 || sr>=r || sc>=c || image[sr][sc]!=curr_color)
        {
            return;
        }


            image[sr][sc] = color;


        helper(image, sr-1, sc, color, curr_color);
        helper(image, sr+1, sc, color, curr_color);
        helper(image, sr, sc-1, color, curr_color);
        helper(image, sr, sc+1, color, curr_color);

    }

    public static void main(String[] args)
    {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        fillColor(image, 1, 1 ,2);
        System.out.println(Arrays.deepToString(image));
    }
}

