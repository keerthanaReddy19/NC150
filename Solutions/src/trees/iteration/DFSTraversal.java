package trees.iteration;

import trees.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSTraversal {
    public static List<String> depthFirstValues(TreeNode root)
    {
        List<String> values = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        if(root == null)
        {
            return List.of();
        }

        s.push(root);

        while(!s.isEmpty())
        {
            TreeNode curr =  s.pop();
            values.add(String.valueOf(curr.val));

            if(curr.right!=null)
            {
                s.push(curr.right);
            }

            if(curr.left!=null)
            {
                s.push(curr.left);
            }
        }

        return values;
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

        System.out.println(depthFirstValues(a));
        System.out.println(depthFirstValues(null));


    }

}
