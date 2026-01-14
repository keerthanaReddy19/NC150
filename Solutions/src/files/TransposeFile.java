//Read from the file and print its transposed content to stdout.
package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransposeFile {

//    public static void transposeFileContent() throws IOException {
//
//        BufferedReader br = new BufferedReader(new FileReader("/Users/keerthanareddy/IdeaProjects/NC150/Solutions/src/Files/file.txt"));
//
//        String line;
//        List<String[]> data = new ArrayList<>();
//
//        while((line = br.readLine())!= null)
//        {
//           data.add(line.split(" "));
//        }
//
//        br.close();
//
//        int row_size = data.size();
//        int col_size = data.get(0).length;
//
//       for(int c = 0; c<col_size; c++)
//       {
//           for(int r =0; r<row_size; r++)
//           {
//               System.out.print(data.get(r)[c]);
//               if(r<row_size-1)
//               {
//                   System.out.print(" ");
//               }
//           }
//           System.out.println();
//
//       }
//
//
//    }


    public static void transposeFileContent() throws IOException {

        FileReader fr = new FileReader("file.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        List<String[]> matrix = new ArrayList<>();
        String[] words;

        while (line != null) {

            words = line.split(" ");
            matrix.add(words);
            line = br.readLine();
        }

        //words = {name, age}, {alice, 21}, {ryan, 30)


        for (int col = 0; col < matrix.get(0).length; col++) {
        for (int row = 0; row < matrix.size(); row++) {

                 System.out.print(matrix.get(row)[col] + " ");
            }
            System.out.println();
        }
        br.close();
    }






















    public static void main(String args[]) throws IOException {
        transposeFileContent();
    }
}