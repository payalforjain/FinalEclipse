package leetcode.easy.Trees;

public class LowestCommonAncestorBST {
	protected BSTNode root;

	/*

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
             according to the LCA definition.
Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the BST.
	 */

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



	BSTNode nonfirstCommonAncestorIter(BSTNode node, int data1, int data2) {

		while (node != null) {

			if (data1 > node.getData() && data2 > node.getData()) {
				node = node.getRight();
			} else if (data1 < node.getData() && data2 < node.getData()) {
				node = node.getLeft();
			} else {
				System.out.println(node.getData());
				return node;
			}
		}
		return node;
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