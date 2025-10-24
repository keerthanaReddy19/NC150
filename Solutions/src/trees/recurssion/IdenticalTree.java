package trees.recurssion;

import trees.node.TreeNode;

public class IdenticalTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            return p == q;
        }

        boolean isLeftSame = isSameTree(p.left, q.left);
        boolean isRightSame = isSameTree(p.right, q.right);

        return isLeftSame && isRightSame && (p.val == q.val);

    }
}
