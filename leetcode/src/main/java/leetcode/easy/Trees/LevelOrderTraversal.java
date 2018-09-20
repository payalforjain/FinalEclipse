package leetcode.easy.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class LevelOrderTraversal {
	protected BSTNode root;

	public void levelOrderTraversal() {

		Queue<BSTNode> s1 = new LinkedList<BSTNode>();
		Queue<BSTNode> s2 = new LinkedList<BSTNode>();
		Queue<BSTNode> temp = new LinkedList<BSTNode>();
		s1.add(root);
		System.out.println("Level Order Traversal");
		while (!s1.isEmpty()) {
			BSTNode n = s1.poll();

			System.out.print(n.getData() + " ");
			if (n.getLeft() != null)
				s2.add(n.getLeft());
			if (n.getRight() != null)
				s2.add(n.getRight());

			if (s1.isEmpty()) {

				System.out.println();
				temp = s1;
				s1 = s2;
				s2 = temp;

			}

		}

	}
//Time complexity of this method is O(n) where n is number of nodes in given binary tree.
	// return as a list
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> out = new ArrayList<List<Integer>>();
		Queue<TreeNode> s1 = new LinkedList<TreeNode>();
		Queue<TreeNode> s2 = new LinkedList<TreeNode>();
		Queue<TreeNode> temp = new LinkedList<TreeNode>();
		List<Integer> in = new ArrayList<Integer>();
		if (root == null) {
			return out;
		}

		s1.add(root);

		// System.out.println("Level Order Traversal");
		while (!s1.isEmpty()) {
			TreeNode n = s1.poll();
			in.add(n.val);
			// System.out.print(n.getData() + " ");
			if (n.left != null)
				s2.add(n.left);
			if (n.right != null)
				s2.add(n.right);

			if (s1.isEmpty()) {
				out.add(in);
				in = new ArrayList<Integer>();

				temp = s1;
				s1 = s2;
				s2 = temp;

			}

		}

		return out;

	}

	/*
	Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
	 */

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> out = new ArrayList<List<Integer>>();
		Queue<TreeNode> s1 = new LinkedList<TreeNode>();
		Queue<TreeNode> s2 = new LinkedList<TreeNode>();
		Queue<TreeNode> temp = new LinkedList<TreeNode>();
		List<Integer> in = new ArrayList<Integer>();
		if (root == null) {
			return out;
		}

		s1.add(root);

		// System.out.println("Level Order Traversal");
		while (!s1.isEmpty()) {
			TreeNode n = s1.poll();
			in.add(n.val);
			// System.out.print(n.getData() + " ");
			if (n.left != null)
				s2.add(n.left);
			if (n.right != null)
				s2.add(n.right);

			if (s1.isEmpty()) {
				out.add(in);
				in = new ArrayList<Integer>();

				temp = s1;
				s1 = s2;
				s2 = temp;

			}

		}

		List<List<Integer>> reversedResult = new ArrayList<List<Integer>>();

		for (int i = out.size() - 1; i >= 0; i--) {
			reversedResult.add(out.get(i));
		}
		return reversedResult;

	}

}
