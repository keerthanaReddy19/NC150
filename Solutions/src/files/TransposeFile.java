//Read from the file and print its transposed content to stdout.
package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TransposeFile {

    public static void transposeFileContent() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("/Users/keerthanareddy/IdeaProjects/NC150/Solutions/src/Files/file.txt"));

        String line;
        List<String[]> data = new ArrayList<>();

        while((line = br.readLine())!= null)
        {
           data.add(line.split(" "));
        }

        br.close();

        int row_size = data.size();
        int col_size = data.get(0).length;

       for(int c = 0; c<col_size; c++)
       {
           for(int r =0; r<row_size; r++)
           {
               System.out.print(data.get(r)[c]);
               if(r<row_size-1)
               {
                   System.out.print(" ");
               }
           }
           System.out.println();

       }


    }

    public static void main(String args[]) throws IOException {
        transposeFileContent();
    }
}