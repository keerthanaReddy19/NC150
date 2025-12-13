package trees.recurssion;

import trees.node.TreeNode;

import java.util.*;

public class RightView {
    List<Integer> values = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root)
    {

        if(root!=null)
        {
            recurssiveRightView(root, 0);
        }
        return values;
    }

    private List<Integer> recurssiveRightView(TreeNode root, int level) {

        if(level == values.size())
        {
            values.add(root.val);
        }
        if(root.right!=null)
        {
            recurssiveRightView(root.right, level+1);
        }

        if(root.left!=null)
        {
            recurssiveRightView(root.left, level+1);
        }

        return values;
    }
}
