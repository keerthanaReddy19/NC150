package trees.iteration;

import trees.node.TreeNode;

import java.util.ArrayList;
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

    //recursive
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
        {
            return -1;
        }

        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result.get(k-1);
    }

    public void inorder(TreeNode root, ArrayList<Integer> result)
    {
        if(root == null)
        {
            return;
        }

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

}
