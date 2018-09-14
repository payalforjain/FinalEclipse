package leetcode.easy.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {
	protected BSTNode root;

	public void printZigZagOrder() { // Mirror Image of a Binary tree Queue
										// using stacks.
		Stack<BSTNode> s1 = new Stack<BSTNode>();
		Stack<BSTNode> s2 = new Stack<BSTNode>();
		Stack<BSTNode> temp = new Stack<BSTNode>();
		s1.push(root);
		boolean leftToRight = false;
		System.out.println("ZigZagOrder Traversal");
		while (!s1.isEmpty()) {
			BSTNode n = s1.pop();
			System.out.print(n.getData() + " ");
			if (!leftToRight) {
				if (n.getLeft() != null)
					s2.push(n.getLeft());
				if (n.getRight() != null)
					s2.push(n.getRight());
			}

			else {
				if (n.getRight() != null)
					s2.push(n.getRight());
				if (n.getLeft() != null)
					s2.push(n.getLeft());
			}

			if (s1.isEmpty()) {
				leftToRight = !leftToRight;
				System.out.println();
				temp = s1;
				s1 = s2;
				s2 = temp;

			}

		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		List<Integer> in = new ArrayList<Integer>();
		if(root == null)
		{
		    return out;
		}
	
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		Stack<TreeNode> temp = new Stack<TreeNode>();
		s1.push(root);
		boolean leftToRight = false;
		System.out.println("ZigZagOrder Traversal");
		while (!s1.isEmpty()) {
			TreeNode n = s1.pop();
			//System.out.print(n.val + " ");
			in.add(n.val);
			if (!leftToRight) {
				if (n.left != null)
					s2.push(n.left);
				if (n.right != null)
					s2.push(n.right);
			}

			else {
				if (n.right != null)
					s2.push(n.right);
				if (n.left != null)
					s2.push(n.left);
			}

			if (s1.isEmpty()) {
				leftToRight = !leftToRight;
				out.add(in);
				 in = new ArrayList<Integer>();
				System.out.println();
				temp = s1;
				s1 = s2;
				s2 = temp;

			}

		}
		return out;
	}
}
