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
public int maxDepthBFS(TreeNode root) {
    if (root == null) {
        return 0;
    }
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    int count = 0;
    while (q.size() > 0) {
        int n = q.size();
        count++;
        for (int i = 0; i < n; i ++) {
            TreeNode node = q.remove();
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right !=null) {
                q.add(node.right);
            }
        }
    }
    return count;
}

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int max_depth = Integer.MIN_VALUE;
        if (root.left != null) {
            max_depth = Math.max(maxDepth(root.left), max_depth);
        }
        if (root.right != null) {
            max_depth = Math.max(maxDepth(root.right), max_depth);
        }

        return max_depth + 1;
    }
}
