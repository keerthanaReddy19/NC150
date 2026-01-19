package trees.recurssion;

import trees.node.TreeNode;

/**
 * LC 297
 * TC: O(n)
 * SC: O(n)
 */

public class SerializeDeserialize {

    int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();

        String serialised = dfsSerialize(root, sb);

        return serialised;
    }


    public String dfsSerialize(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("#");
            sb.append(",");
            return "";
        }

        sb.append(root.val);
        sb.append(",");
        dfsSerialize(root.left, sb);
        dfsSerialize(root.right, sb);

        String serialised_string = sb.toString();

        return serialised_string;

    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null) {
            return null;
        }

        index = 0;
        String splitArray[] = data.split(",");

        TreeNode result = dfsDeserialize(splitArray);
        return result;
    }

    public TreeNode dfsDeserialize(String[] splitArray) {
        if (splitArray[index].equals("#")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(splitArray[index]));

        index++;

        root.left = dfsDeserialize(splitArray);
        root.right = dfsDeserialize(splitArray);

        return root;
    }
}

//        public String serialize(TreeNode root) {
//            if(root == null) return null;
//
//            StringBuilder sb = new StringBuilder();
//            dfsSerialize(root, sb);
//            return sb.toString();
//        }
//
//        private void dfsSerialize(TreeNode root, StringBuilder sb){
//            if(root == null){
//                sb.append("#");
//                sb.append(",");
//                return;
//            }
//
//            sb.append(root.val);
//            sb.append(",");
//            dfsSerialize(root.left, sb);
//            dfsSerialize(root.right, sb);
//        }
//
//
//        int idx = 0;
//        public TreeNode deserialize(String data) {
//            if(data == null) return null;
//
//            String[] splitArr = data.split(",");
//            return dfsDeserialize(splitArr);
//        }
//
//        private TreeNode dfsDeserialize(String[] splitArr){
//            if(splitArr[idx].equals("#")){
//                idx++;
//                return null;
//            }
//
//            TreeNode root = new TreeNode(Integer.parseInt(splitArr[idx]));
//            idx++;
//
//            root.left = dfsDeserialize(splitArr);
//            root.right = dfsDeserialize(splitArr);
//
//            return root;
//        }



