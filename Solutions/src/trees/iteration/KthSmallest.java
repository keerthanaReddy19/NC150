package trees.iteration;

import trees.node.TreeNode;

import java.util.Stack;

public class KthSmallest {
    public int kthSmallestNode(TreeNode root, int k) {

        int i = 0;
        Stack<TreeNode> s = new Stack<>();

        while (true) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            root = s.pop();
            i++;

            if (i == k) {
                return root.val;
            }


            root = root.right;

        }
    }

}
