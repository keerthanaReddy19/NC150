package trees.recurssion;

import trees.node.TreeNode;

public class Traversal {
    public static void printTree(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
