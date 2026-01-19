package trees.bfs;

import trees.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 101
 * TC: O(n)
 * SC: O(n)
 */

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> values = new LinkedList<>();

        //edge case
        if(root==null)
        {
            return true;
        }

        values.add(root.left);
        values.add(root.right);

        while(!values.isEmpty())
        {
            TreeNode value1 = values.remove();
            TreeNode value2 = values.remove();

            if(value1 == null && value2 == null)
            {
                continue;
            }

            if(value1 == null || value2 == null)
            {
                return false;
            }

            if(value1.val!=value2.val)
            {
                return false;
            }

            values.add(value1.left);
            values.add(value2.right);
            values.add(value1.right);
            values.add(value2.left);
        }
        return true;

    }
}
