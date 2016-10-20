package bst;

import java.util.LinkedList;

public class Additional extends BST {
	
	
	/**
	 * Diameter of a Tree is defined as the number of nodes on the longest path between two leaves in the tree.
	 * http://crackinterviewtoday.wordpress.com/2010/03/11/diameter-of-a-binary-tree/
	 
	 */
	
	 public int diameterOfTree()
	 {
		 return diameterOfTree(root);
	 }
    public int diameterOfTree(BSTNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = heightOfTree((BSTNode) node.getLeft());
        int rightHeight = heightOfTree((BSTNode) node.getRight());
        int leftDiameter = diameterOfTree((BSTNode) node.getLeft());
        int rightDiameter = diameterOfTree((BSTNode) node.getRight());
        int pathLengthTroughRoot = leftHeight + rightHeight + 1;
        int maxOfLeftAndRightDiameter = Math.max(leftDiameter, rightDiameter);
        return Math.max(pathLengthTroughRoot, maxOfLeftAndRightDiameter);
    }

    /*
    * Find max height of tree. Similar to balanced tree.
    * */
    private int heightOfTree(BSTNode node) {
        if (node == null) {
            return 0;
        }
        int maxLeftHeight = heightOfTree((BSTNode) node.getLeft());
        int maxRightHeight = heightOfTree((BSTNode) node.getRight());
        int max = Math.max(maxLeftHeight, maxRightHeight);
        return 1 + max;
    }

  // http://www.programcreek.com/2014/03/leetcode-symmetric-tree-java/
    // check if two trees or symmetric or not
    public boolean isSymmetric(BSTNode root) {
    	if (root == null)
    		return true;
    	return isSymmetric(root.left, root.right);
    }
     
    public boolean isSymmetric(BSTNode l, BSTNode r) {
    	if (l == null && r == null) {
    		return true;
    	} else if (r == null || l == null) {
    		return false;
    	}
     
    	if (l.data != r.data)
    		return false;
     
    	if (!isSymmetric(l.left, r.right))
    		return false;
    	if (!isSymmetric(l.right, r.left))
    		return false;
     
    	return true;
    }
    
    public boolean isSameTree(BSTNode p, BSTNode q) 
    {
        if(p==null && q==null)
        {
            return true;
        }
        else if(p==null || q==null)
        {   
            return false;
        }
        else
        {
            return (p.data == q.data && 
                    isSameTree(p.left,q.left) && 
                    isSameTree(p.right,q.right));
        }
    }

    public static void main(String args[])
    {
    	Additional a = new Additional();
    	System.out.println(a.diameterOfTree());
    }
}
