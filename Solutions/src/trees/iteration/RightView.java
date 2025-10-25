package trees.iteration;

import trees.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {

    public static List<Integer> rightView(TreeNode root)
    {
        if(root == null)
        {
            return  new ArrayList<>();
        }
        List<Integer> val = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();

            TreeNode curr = null;
            for (int i = 0; i < size; i++) {
                curr = q.remove();
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            val.add(curr.val);
        }
        return val;
    }

    public static void main(String args[])
    {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(8);
        TreeNode e = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(rightView(a));
        System.out.println(rightView(null));

    }

}
