package trees;

public class InvertTree {
    public static TreeNode invert(TreeNode root) {

        if(root == null)
        {
            return root;
        }

        TreeNode left =  invert(root.left);
        TreeNode right = invert(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }



    public static void main(String[] args)
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

        TreeNode soln = invert(a);
        Traversal.printTree(soln);

    }
}
