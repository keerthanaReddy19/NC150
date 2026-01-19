package trees.recurssion;

import trees.node.TreeNode;

/**
 * LC 236
 * TC : O(n), SC: O(n)
 */

public class LCA_BT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        else
            return right;
        }
    }































