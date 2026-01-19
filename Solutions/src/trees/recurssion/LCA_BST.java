package trees.recurssion;

import trees.node.TreeNode;

/**
 * 235
 */

public class LCA_BST {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        {
            return null;
        }

        if(p.val <= root.val && q.val >= root.val)
        {
            return root;
        }
        else if(p.val<root.val && q.val<root.val)
        {
            return lowestCommonAncestor(root.left, p,  q);
        }
        else if(p.val>root.val && q.val>root.val)
        {
            return lowestCommonAncestor(root.right, p,  q);
        }
        return root;
    }

    public static void main(String args[])
    {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        TreeNode ans = lowestCommonAncestor(a, b, c);
        System.out.println(ans.val);

    }
}
