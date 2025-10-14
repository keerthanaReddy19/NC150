package trees;

/*
LC:543: Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

           1
        /     \
       2       3
      / \     / \
     4   5   N   N
   / \ / \
   N  N N  N

approach:
--> may or may not pass through the root

if root is part of it: left height + right height;
if root is not part of it: right diameter or left diameter
--> max((left height + right height), right-diameter, left diameter)

 */

public class Diameter {
    /* TC: O(n^2)
    public static int calcDiameter(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int leftDiameter = calcDiameter(root.left);
        int rightDiameter = calcDiameter(root.right);

        int leftHeight = MaxDepth.calcDepth(root.left);
        int rightHeight = MaxDepth.calcDepth(root.right);
        int current_diameter =  +  leftHeight + rightHeight;

        return Math.max((current_diameter), Math.max(leftHeight , rightHeight));
    } */

    /* optimised approach O(n) */

    //global variable to track the diameter
    static int ans = 0;

    public int calcDiameter(TreeNode root) {

        calcSum(root);

        return ans;

    }

    //Calc height and diameter
    public static int calcSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lsum = calcSum(root.left);
        int rsum = calcSum(root.right);

        //Height + diameter
        ans = Math.max(lsum, rsum) + 1;
        return Math.max(lsum, rsum) + 1;
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        System.out.println(calcSum(a));

    }
}
