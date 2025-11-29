//LC 609
package files;

import java.util.*;

class DuplicateFiles {
    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> final_path = new ArrayList<>();
        String[] values;
        String[] filename_content;
        HashMap<String,List<String>> hm = new HashMap<>();

        for(String path: paths)
        {
           values = path.split(" ");
           for(int i = 1;i<values.length;i++) {
               filename_content = values[i].split("\\(");
               String content = filename_content[1];
               List<String> filepath = hm.getOrDefault(content,new ArrayList<String>());
               filepath.add(values[0] + "/" + filename_content[0]);
               hm.put(content, filepath);
           }
           }

        for(String s: hm.keySet())
        {
            if(hm.get(s).size()>1)
            {
                final_path.add(hm.get(s));
            }
        }

        return final_path;
    }

    public static void main(String[] args)
    {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }
}
