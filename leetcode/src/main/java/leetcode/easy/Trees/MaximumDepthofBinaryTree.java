package leetcode.easy.Trees;
import java.util.*;
public class MaximumDepthofBinaryTree {
/*
ven a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */
    public int maxDepthIter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> s1 = new LinkedList<TreeNode>();
        Queue<TreeNode> s2 = new LinkedList<TreeNode>();
        Queue<TreeNode> temp = new LinkedList<TreeNode>();
        List<Integer> in = new ArrayList<Integer>();


        s1.add(root);

        // System.out.println("Level Order Traversal");
        while (!s1.isEmpty()) {
            TreeNode n = s1.poll();
            in.add(n.val);



            if (n.left != null)
                s2.add(n.left);
            if (n.right != null)
                s2.add(n.right);

            if (s1.isEmpty()) {
                count ++ ;
                in = new ArrayList<Integer>();

                temp = s1;
                s1 = s2;
                s2 = temp;

            }

        }

        return count;

    }

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int bigger = Math.max(leftDepth, rightDepth);

        return bigger+1;
    }
}
