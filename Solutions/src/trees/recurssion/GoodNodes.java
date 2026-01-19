package trees.recurssion;

import trees.node.TreeNode;

public class GoodNodes {
//        static int count = 0;
//        public static int goodNodeCount(TreeNode root)
//        {
//            if (root == null) {
//                return 0;
//            }
//           helper(root, root.val);
//           return count;
//
//        }
//
//        private static void helper(TreeNode root, int max_val) {
//            if (max_val <= root.val) {
//                count++;
//                max_val = root.val;
//            }
//
//            if (root.left != null) {
//                helper(root.left, max_val);
//            }
//            if (root.right != null) {
//                helper(root.right, max_val);
//            }
//        }
//
//
//
//        public static void main(String args[])
//        {
//            TreeNode a = new TreeNode(5);
//            TreeNode b = new TreeNode(6);
//            TreeNode c = new TreeNode(7);
//            TreeNode d = new TreeNode(8);
//            TreeNode e = new TreeNode(9);
//            a.left = b;
//            a.right = c;
//            b.left = d;
//            b.right = e;
//
//            System.out.println(goodNodeCount(a));
//           // System.out.println(goodNodeCount(null));
//
//        }

    private int max_value = Integer.MIN_VALUE;
    private int count = 0;
    public int goodNodes(TreeNode root) {
        if(root!=null)
        {

            countGoodNodes(root, max_value);

        }
        return count;
    }

    public void countGoodNodes(TreeNode root, int max_value)
    {

        if(root.val>=max_value)
        {
            count++;
            max_value = root.val;
        }
        if(root.left!=null)
        {
            countGoodNodes(root.left, max_value);
        }
        if(root.right!=null)
        {
            countGoodNodes(root.right, max_value);
        }

    }

    }



