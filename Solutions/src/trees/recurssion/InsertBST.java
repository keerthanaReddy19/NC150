package trees.recurssion;

import trees.node.TreeNode;

/**
 * Lc 701
 */
public class InsertBST {
    public TreeNode insertIntoBST(TreeNode root, int val)
    {
        TreeNode node = root;

        while(node!=null)
        {
            if(val>node.val)
            {
                if(node.right==null)
                {
                    node.right = new TreeNode(val);
                    return root;
                }
                else
                {
                    node = node.right;
                }
            }
            else
            {
                if(node.left==null)
                {
                    node.left = new TreeNode(val);
                    return root;
                }
                node = node.left;
            }
        }

        return new TreeNode(val);
    }


    /* recursive
     public TreeNode insertIntoBST(TreeNode root, int val) {
         if(root == null)
         {
             return new TreeNode(val);
         }

         if(val>root.val)
         {
            root.right = insertIntoBST(root.right, val);
         }
         else
         {
            root.left = insertIntoBST(root.left, val);
         }
     }
     */
}
