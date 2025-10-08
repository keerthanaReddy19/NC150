package trees;

public class MaxDepth {
    public int calcDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int depth = 0;
        return calcSum(root , depth);
    }

    public static int calcSum(TreeNode root, int sum)
    {
        if(root == null)
        {
            return 0;
        }
        int lsum = 1 + calcSum(root.left, root.val);
        int rsum = 1 + calcSum(root.right, root.val);

        return Math.max(lsum,rsum);
    }
}
