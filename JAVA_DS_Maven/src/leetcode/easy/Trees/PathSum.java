package leetcode.easy.Trees;

import bst.BSTNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class PathSum {

	public BSTNode root;

	public boolean pathSum(int a) {
		return pathSum(root, a);
	}

	public boolean pathSum(BSTNode node, int a) {
		if (node == null)
			return false;
		if (node.getData() == a && node.getLeft() == null && node.getRight() == null)
			return true;
		else
			return pathSum(node.getLeft(), a - node.getData()) || pathSum(node.getRight(), a - node.getData());
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
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null)
			return result;

		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(root.val);
		dfs(root, sum - root.val, result, l);
		return result;
	}

	public void dfs(TreeNode t, int sum, List<List<Integer>> result, ArrayList<Integer> l) {
		if (t.left == null && t.right == null && sum == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(l);
			result.add(temp);
		}

		// search path of left node
		if (t.left != null) {
			l.add(t.left.val);
			dfs(t.left, sum - t.left.val, result, l);
			l.remove(l.size() - 1);
		}

		// search path of right node
		if (t.right != null) {
			l.add(t.right.val);
			dfs(t.right, sum - t.right.val, result, l);
			l.remove(l.size() - 1);
		}
	}
}