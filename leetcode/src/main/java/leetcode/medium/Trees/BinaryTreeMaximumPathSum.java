package leetcode.medium.Trees;
import leetcode.Model.TreeNode;
public class BinaryTreeMaximumPathSum {
/*
iven a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */
/*
For each node there can be four ways that the max path goes through the node:
1. Node only
2. Max path through Left Child + Node
3. Max path through Right Child + Node
4. Max path through Left Child + Node + Max path through Right Child
 */

   // Time Complexity: O(n) where n is number of nodes in Binary Tree.
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {


        calculateSum(root);
        return maxValue;
    }

    public int calculateSum(TreeNode root) {
        if (root == null)
            return 0;

        // l and r store maximum path sum going through left and
        // right child of root respectively
        int left = calculateSum(root.left);
        int right = calculateSum(root.right);


        // Max path for parent call of root. This path must
        // include at-most one child of root
        int current = Math.max(Math.max(left, right) + root.val, root.val);

        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(current, left + right + root.val);

        maxValue = Math.max(maxValue , max_top); // Store the Maximum Result.

        return current;
    }
}
