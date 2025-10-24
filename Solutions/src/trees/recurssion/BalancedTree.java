package trees.recurssion;

import trees.node.TreeNode;

public class BalancedTree {
    public boolean isBalanced(TreeNode root) {

        if (findDepth(root) == -1) {
            return false;
        }
        return true;

    }

    /*
    Here, the function doesn't return the height if tree is unbalanced.
     */
    public int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = findDepth(root.left);
        int right = findDepth(root.right);

      /*if unbalanced, don't return the height, return -1 (indicating it's unbalanced)
      check if child node is unbalanced and return -1 instead of checking all the way up to parent */

        if (left == -1 || right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;

    }
}
