package trees.recurssion;
/*
LC 104
Top-down Approach: Increase count at each level for left subtree and right subtree.
Return the max count

Bottom-down approach: Max(lh, rh) + 1;

Tc: O(n)
Sc: O(n)
 */

import trees.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

//    public static int calcSum(TreeNode root)
//    {
//        if(root == null)
//        {
//            return 0;
//        }
//        int lsum =  calcSum(root.left);
//        int rsum =  calcSum(root.right);
//
//        return Math.max(lsum,rsum) + 1;
//    }

//

    //revisit
    public int maxDepth(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    //iterative
    public int maxTreeDepth(TreeNode root) {

        if(root==null)
        {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int depth = 0;

        while(!q.isEmpty())
        {
            int q_size = q.size();

            for(int i=0;i<q_size;i++)
            {
                TreeNode curr = q.remove();

                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            depth++;

        }

            return depth;

    }
}

