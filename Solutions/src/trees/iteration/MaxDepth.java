package trees.iteration;

import trees.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public static int findMaxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
        {
            return 0;
        }

        q.add(root);
        int depth = 0;

        while(!q.isEmpty())
        {
            int levelSize = q.size();
            for(int i = 0; i<levelSize; i++)
            {
                TreeNode t = q.poll();

                if(t.right!=null)
                {
                    q.add(t.right);
                }
                if(t.left!=null)
                {
                    q.add(t.left);
                }
            }
            depth++;
        }
        return depth;
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

        System.out.println(findMaxDepth(a));
    }
}
