package leetcode.medium.Trees;

public class SubTree {
	
	
	/*
	 * Do this as well
	 * 
	 * https://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
	 */

	/*
	 * Given two binary trees, check if the first tree is subtree of the second
	 * one. A subtree of a tree T is a tree S consisting of a node in T and all
	 * of its descendants in T. The subtree corresponding to the root node is
	 * the entire tree; the subtree corresponding to any other node is called a
	 * proper subtree.
	 * 
	 * For example, in the following case, tree S is a subtree of tree T.
	 * 
	 * Tree 2 10 / \ 4 6 \ 30
	 * 
	 * 
	 * Tree 1 26 / \ 10 3 / \ \ 4 6 3 \ 30
	 */

	class Node {
		int data;
		Node left, right, nextRight;

		Node(int item) {
			data = item;
			left = right = nextRight = null;
		}
	}

	class BinaryTree {
		
		
		
		Node root1, root2;

		/*
		 * A utility function to check whether trees with roots as root1 and
		 * root2 are identical or not
		 */
		boolean areIdentical(Node root1, Node root2) {

			/* base cases */
			if (root1 == null && root2 == null)
				return true;

			if (root1 == null || root2 == null)
				return false;

			/*
			 * Check if the data of both roots is same and data of left and
			 * right subtrees are also same
			 */
			return (root1.data == root2.data && areIdentical(root1.left, root2.left)
					&& areIdentical(root1.right, root2.right));
		}

		/* This function returns true if S is a subtree of T, otherwise false */
		boolean isSubtree(Node T, Node S) {
			/* base cases */
			if (S == null)
				return true;

			if (T == null)
				return false;

			/* Check the tree with root as current node */
			if (areIdentical(T, S))
				return true;

			/*
			 * If the tree with root as current node doesn't match then try left
			 * and right subtrees one by one
			 */
			return isSubtree(T.left, S) || isSubtree(T.right, S);
		}

	}

}
