package trees.recurssion;
/*

Top-down Approach: Increase count at each level for left subtree and right subtree.
Return the max count

Bottom-down approach: Max(lh, rh) + 1;

 */
import trees.node.TreeNode;

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

    public int maxDepth(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int c = 0;
        return calcMaxDepth(root, 0);

    }
    public int calcMaxDepth(TreeNode root, int c)
    {

        if(root == null)
        {
            return c;
        }
        int left_depth = calcMaxDepth(root.left, c+1);


        int right_depth = calcMaxDepth(root.right, c+1);

        return Math.max(left_depth, right_depth);
    }
}
