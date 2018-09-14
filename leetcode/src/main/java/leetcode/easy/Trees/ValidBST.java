package leetcode.easy.Trees;

import java.util.Stack;

public class ValidBST {

	public boolean isValidBSTIter(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode> ();
		TreeNode cur = root ;
		TreeNode pre = null ;		   
		while (!stack.isEmpty() || cur != null) {			   
			if (cur != null) {
				stack.push(cur);
				cur = cur.left ;
			} else {				   
				TreeNode p = stack.pop() ;
				if (pre != null && p.val <= pre.val) {					   
					return false ;
				}				   
				pre = p ;					   
				cur = p.right ;
			}
		}
		return true ; 
	}

	public int findMin(TreeNode node) {
		if (node == null)
			return -1;
		else {
			while (node.left != null) {
				node = node.left;
			}
		}
		return node.val;
	}

	public int findMax(TreeNode node) {
		if (node == null)
			return -1;
		else {
			while (node.right != null) {
				node = node.right;
			}
		}
		return node.val;
	}

	/*
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
	 * path such that adding up all the values along the path equals the given
	 * sum.
	 */

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, findMin(root), findMax(root));
	}

	public boolean isValidBST(TreeNode node, int min, int max) {

		if (node == null)
			return true;

		if (node.val < min || node.val > max)
			return false;

		return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
	}

}
