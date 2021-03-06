package leetcode.medium.Trees;

//Java program to find diameter of a 
//binary tree using DFS.
import leetcode.Model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class DiameterOfTree {
/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */
private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);
        return  1 + Math.max(left, right);

    }

    //Time O(N) Space O(N)

    /*
    Time Complexity: O(N)O(N). We visit every node once.

Space Complexity: O(N)O(N), the size of our implicit call stack during our depth-first search.
     */
}