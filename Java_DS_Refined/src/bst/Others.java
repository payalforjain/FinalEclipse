package bst;



public class Others {
	//Given two binary trees check if they are mir­ror image of each other.
	//http://algorithms.tutorialhorizon.com/check-if-one-binary-is-mirror-tree-of-another-binary-tree/
	public boolean checkMirror(BSTNode root1, BSTNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
                if(root1.data !=root2.data){
                        return false;
                }

		if ((root1 == null && root2 != null)
				|| (root1 != null && root2 == null)) { // if any node doesn't
														// have corresponding
														// node in the another
														// tree, return false
			return false;
		}
		// check if left node in one tree is the right node in another tree, and
		// vice versa
		return checkMirror(root1.left, root2.right)
				&& checkMirror(root1.right, root2.left);

	}
	
}


// This is a java program to check whether a binary tree is subtree of another tree
//http://www.sanfoundry.com/java-program-check-whether-input-binary-tree-sub-tree-binary-tree/