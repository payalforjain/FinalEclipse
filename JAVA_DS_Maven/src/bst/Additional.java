package bst;

import java.util.LinkedList;

public class Additional extends BST {
	
	//http://algorithms.tutorialhorizon.com/diameter-of-a-binary-tree/
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

  
    
  
    public static void main(String args[])
    {
    	Additional a = new Additional();
    	System.out.println(a.diameterOfTree());
    }
}
