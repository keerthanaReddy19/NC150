package trees.recurssion;

import trees.node.TreeNode;

/**
 * LC 236
 * TC : O(n), SC: O(n)
 */

/*
       3
   5        1
6    2    0    8
   7   4

   p = 5, q = 1

  LCA(3):
  Root: 3
  TreeNode left: LCA(5)  //returns 5
  TreeNode right: LCA(1) //returns 1
  returns 3



  LCA(5):
  Root: 5
  P == 5
  return 5;

LCA(1)
root : 1
q == 1
return 1

       3
   5        1
6    2    0    8
   7   4

   p = 5, q = 4

LCA(3):  returns 5
 left: LCA(5): returns 5
 right: LCA(1): returns null
          left:   LCA(0) returns null
                    left: LCA(null) //return null
                    right: returns null
           right:  LCA(8): returns null


case1:
if current root is a match: either p or q or null:
return the root

DFS on root.left
DFS on root.right

if both left and right found a node, ie left,right!=null:
 then return root;

if left found a node ie left!=null:
 then return left;

if(right found a node, ie right!=null
 then return right;





  */
public class LCA_BT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        else
            return right;
        }
    }































