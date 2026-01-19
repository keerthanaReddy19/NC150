package trees.recurssion;

import trees.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Preorder {
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if(root == null)
    //     {
    //         return new ArrayList<>();
    //     }

    //     List<Integer> result = new ArrayList<>();
    //     result.add(root.val);

    //     result.addAll(preorderTraversal(root.left));

    //     result.addAll(preorderTraversal(root.right));

    //     return result;

    // }

    public List<Integer> preorderTraversal(TreeNode root)
    {

        if(root == null)
        {
            return List.of();
        }

        List<Integer> result = new ArrayList<>();

        dfs(root, result);

        return result;

    }


    public void dfs(TreeNode root, List<Integer> result)
    {
        if(root == null)
        {
            return;
        }

        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
    }
}


