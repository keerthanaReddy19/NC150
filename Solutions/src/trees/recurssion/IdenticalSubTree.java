package trees.recurssion;

import trees.node.TreeNode;

import static trees.recurssion.IdenticalTree.*;

public class IdenticalSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null || subRoot == null) {
            return root == subRoot;
        }
        if (root.val == subRoot.val) {
            if (isSameTree(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);


    }

}
