//LC 609
package files;

import java.util.*;

class DuplicateFiles {
//    public static List<List<String>> findDuplicate(String[] paths) {
//        List<List<String>> final_path = new ArrayList<>();
//        String[] values;
//        String[] filename_content;
//        HashMap<String,List<String>> hm = new HashMap<>();
//
//        for(String path: paths)
//        {
//           values = path.split(" ");
//           for(int i = 1;i<values.length;i++) {
//               filename_content = values[i].split("\\(");
//               String content = filename_content[1];
//               List<String> filepath = hm.getOrDefault(content,new ArrayList<String>());
//               filepath.add(values[0] + "/" + filename_content[0]);
//               hm.put(content, filepath);
//           }
//           }
//
//
//
//
//        for(String s: hm.keySet())
//        {
//            if(hm.get(s).size()>1)
//            {
//                final_path.add(hm.get(s));
//            }
//        }
//
//        return final_path;
//    }

    public static List<List<String>> findDuplicate(String[] paths) {

        List<List<String>> filenames = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();

        for(String s: paths)
        {
            String[] values = s.split(" ");
            for(int i = 1; i<values.length; i++)
            {
                String content_data[] = values[i].split("\\(");
                String file_content = content_data[1].replace(")", "");
                String file_path = values[0] + "/" + content_data[0];

                if(hm.containsKey(file_content))
                {
                    hm.get(file_content).add(file_path);
                }
                else
                {
                    List<String> val = new ArrayList<>();
                    val.add(file_path);
                    hm.put(file_content, val);
                }

            }

        }

        for(String s: hm.keySet())
        {
            if(hm.get(s).size()>1)
            {
                filenames.add(hm.get(s));
            }
        }

        /*

        paths = ["root/a 1.txt(abcd) 2.txt(efgh)",
        "root/c 3.txt(abcd)",
        "root/c/d 4.txt(efgh)",
        "root 4.txt(efgh)"]

        values : "root/a", "1.txt(abcd)", "2.txt(efgh)"
        content_data : "1.txt", "abcd)"
        content: "abcd"

        HM:
        V                                           K
        root/a/2.txt, root/c/d/4.txt, root/4.txt   efgh
        root/a/1.txt, root/c/3.txt                 abcd



        o/p: ["root/a/2.txt", "root/c/d/4.txt", "root/4.txt"],
        ["root/a/1.txt","root/c/3.txt"]



        */
        return filenames;

    }

    public static void main(String[] args)
    {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }
}
