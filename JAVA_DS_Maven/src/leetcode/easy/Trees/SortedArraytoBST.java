
package leetcode.easy.Trees;

public class SortedArraytoBST {
	public TreeNode sortedArrayToBST(int[] nums) {
	       return    sortedArrayToBST(nums, 0 , nums.length - 1) ;
	    }
	    
	     private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
	          if (start > end) {
	            return null;
	        }
	 
	        /* Get the middle element and make it root */
	        int mid = (start + end) / 2;
	        TreeNode node = new TreeNode(nums[mid]);
	 
	        /* Recursively construct the left subtree and make it
	         left child of root */
	        node.left = sortedArrayToBST(nums, start, mid - 1);
	 
	        /* Recursively construct the right subtree and make it
	         right child of root */
	        node.right = sortedArrayToBST(nums, mid + 1, end);
	         
	        return node;
	    }
}
