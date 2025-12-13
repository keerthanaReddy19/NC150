package trees.recurssion;

import trees.node.TreeNode;

import java.util.*;
/*
Create a new empty list at start of every level
ie. (level == size)
and add root (right and left child elements to the new list);
 */

public class LevelOrderTraversal {
    List<List<Integer>> values = new ArrayList<>();
    public  List<List<Integer>> levelOrder(TreeNode root)
    {

        if(root!=null) {
            levelOrderRecurssive(root, 0);
        }
        return values;
    }

    private List<List<Integer>>  levelOrderRecurssive(TreeNode root,  int level){
        if(values.size()==level)
        {
            values.add(new ArrayList<Integer>());
        }
        values.get(level).add(root.val);

        if(root.left!=null)
        {
            levelOrderRecurssive(root.left, level+1);

        }

        if(root.right!=null)
        {
            levelOrderRecurssive(root.right, level+1);
        }


        return values;

    }

}
