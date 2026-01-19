package trees.recurssion;

public class Min_distance {
    TreeNode prev = null;
    int min_value = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {


        if(root==null)
        {
            return 0;
        }

        inorder(root);
        return min_value;
    }

    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }

        inorder(root.left);
        if(prev!=null)
        {
            min_value = Math.min(min_value, (root.val-prev.val));
        }
        prev = root;
        inorder(root.right);

    }
}
