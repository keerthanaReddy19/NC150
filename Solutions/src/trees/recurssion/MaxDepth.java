package trees.recurssion;

import trees.node.TreeNode;

public class MaxDepth {

    public static int calcSum(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int lsum =  calcSum(root.left);
        int rsum =  calcSum(root.right);

        return Math.max(lsum,rsum) + 1;
    }
}
