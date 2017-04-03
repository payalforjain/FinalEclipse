package leetcode.easy.Trees;

import bst.BSTNode;

public class LowestCommonAncestor {
	protected BSTNode root;

	public BSTNode findLca(int t1, int t2) {
		return findLca(root, t1, t2);
	}

	public BSTNode findLca(BSTNode node, int t1, int t2) {
		if (node == null)
			return null;

		if (t1 < node.getData() && t2 < node.getData())// both targets are left
			return findLca(node.getLeft(), t1, t2);
		else if (t1 > node.getData() && t2 > node.getData()) // both targets are
																// right
			return findLca(node.getRight(), t1, t2);
		else {

			System.out.println(node.getData());
			return node;
		}
	}
	
	
	  public TreeNode lowestCommonAncestor(TreeNode node, TreeNode t1, TreeNode t2) {
		  
		  if (node == null)
				return null;

			if (t1.val < node.val && t2.val < node.val)// both targets are left
				return lowestCommonAncestor(node.left, t1, t2);
			else if (t1.val > node.val && t2.val > node.val) // both targets are
																	// right
				return lowestCommonAncestor(node.right, t1, t2);
			else {

			
				return node;
			}
	        
	    }
	    

}
