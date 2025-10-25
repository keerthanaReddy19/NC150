package trees.iteration;

import trees.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        if(root == null)
        {
            return  new ArrayList<>();
        }
        List<List<Integer>> values = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();


        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> val = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode curr = q.remove();
                val.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            values.add(val);
        }
        return values;
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

        System.out.println(levelOrder(a));
        System.out.println(levelOrder(null));

    }
}
