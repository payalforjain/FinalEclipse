package leetcode.easy.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDepth {
/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.

// Do Level Order Traversl
 */
    public int minDepthIter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        Queue<TreeNode> s1 = new LinkedList<TreeNode>();
        Queue<TreeNode> s2 = new LinkedList<TreeNode>();
        Queue<TreeNode> temp = new LinkedList<TreeNode>();
        List<Integer> in = new ArrayList<Integer>();


        s1.add(root);

        // System.out.println("Level Order Traversal");
        while (!s1.isEmpty()) {
            TreeNode n = s1.poll();
            in.add(n.val);

            if(n.left == null && n.right == null){
                return count;
            }

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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }


}
