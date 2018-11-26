package leetcode.easy.Trees;

import java.util.Stack;

public class ValidBST {
/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
 */
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



	public boolean isValidBST(TreeNode root) {
		if(root==null)
			return true;

		return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	public boolean helper(TreeNode root, double low, double high){

		if(root.val<=low || root.val>=high)
			return false;

		if(root.left!=null && !helper(root.left, low, root.val)){
			return false;
		}

		if(root.right!=null && !helper(root.right, root.val, high)){
			return false;
		}

		return true;
	}


}
