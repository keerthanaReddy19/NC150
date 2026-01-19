package trees.iteration;

import trees.node.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {

    public static List<String> breadthFirstValues(TreeNode root) {
        List<String> values = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();

        if (root == null) {
            return List.of();
        }

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            values.add(String.valueOf(curr.val));

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
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

            System.out.println(breadthFirstValues(a));
            System.out.println(breadthFirstValues(null));

        }
    }

