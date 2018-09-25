package leetcode.easy.Trees;

import java.util.ArrayList;
import java.util.*;


public class PathSum{
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */


	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.val == sum && (root.left == null && root.right == null))
			return true;

		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}
	public boolean hasPathSumIter(TreeNode root, int sum) {
		if(root == null) return false;

		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> values = new LinkedList<Integer>();

		nodes.add(root);
		values.add(root.val);

		while(!nodes.isEmpty()){
			TreeNode curr = nodes.poll();
			int sumValue = values.poll();

			if(curr.left == null && curr.right == null && sumValue==sum){
				return true;
			}

			if(curr.left != null){
				nodes.add(curr.left);
				values.add(sumValue+curr.left.val);
			}

			if(curr.right != null){
				nodes.add(curr.right);
				values.add(sumValue+curr.right.val);
			}
		}

		return false;
	}

	/*
	 * Given a binary tree and a sum, find all root-to-leaf paths where each
	 * path's sum equals the given sum.
	 * 
	 * For example, given the below binary tree and sum = 22,
	 * 
	 * 5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1 the method returns the following:
	 * 
	 * [ [5,4,11,2], [5,8,4,5] ] Analysis
	 */
	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer>  cur = new ArrayList<>(); // 中间结果
		pathSum2(root, sum, cur, result);
		return result;
	}
	private static void pathSum2(TreeNode root, int gap, ArrayList<Integer> cur,
								List<List<Integer>> result) {
		if (root == null) return;

		cur.add(root.val);

		if (root.left == null && root.right == null) { // leaf
			if (gap == root.val)
				result.add(new ArrayList<>(cur));
		}
		pathSum2(root.left, gap - root.val, cur, result);
		pathSum2(root.right, gap - root.val, cur, result);

		cur.remove(cur.size() - 1);
	}
}