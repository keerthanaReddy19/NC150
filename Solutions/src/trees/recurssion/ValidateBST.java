package trees.recurssion;

import trees.node.TreeNode;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if((root == null) || (root.left == null && root.right == null))
        {
            return true;
        }
        if(root.left!= null && root.left.val<root.val && root.right!=null && root.right.val> root.val)
        {
            return true;
        }
        if((root.left!=null && root.left.val>=root.val) || (root.right!=null && root.right.val<=root.val))
        {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
    }

