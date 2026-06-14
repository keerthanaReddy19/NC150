package trees.recurssion;

import trees.node.TreeNode;

import java.util.*;

/*
        1
     2     3
       5     4

  RRV(1, L0):
  level 0
  values.size = 0
  values = {1}
    right: RRV( 3, L1):
            level: 1
            size == level
            values = {1,3}
    left: RRV(2, L1)
          size=? No
          RRV(3, L2)
          size=? No
               right: RRV(4, L2)  return {1,3,4}
                level : 2
                level == size
                values: {1,3,4}
               left: RRV(null,L3) return {1,3,4}
                 right: RRV(null, L3): return values: {1,3,4}
                 left:  RRV(null, L3): return values: {1,3,4}

 */

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
