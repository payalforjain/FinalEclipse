package leetcode.easy.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	
	
	/*
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
	 */
	 public boolean isSymmetric(TreeNode root) {
		    if(root==null) return true;
		    return isMirror(root.left,root.right);
		}
		public boolean isMirror(TreeNode p, TreeNode q) {
		    if(p==null && q==null) return true;
		    if(p==null || q==null) return false;
		    return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
		}
		
		 public boolean isSymmetricIterative(TreeNode root) {
		        Queue<TreeNode> q = new LinkedList<TreeNode>();
		        if(root == null) return true;
		        q.add(root.left);
		        q.add(root.right);
		        while(q.size() > 1){
		            TreeNode left = q.poll(),
		                     right = q.poll();
		            if(left== null&& right == null) continue;
		            if(left == null ^ right == null) return false;
		            if(left.val != right.val) return false;
		            q.add(left.left);
		            q.add(right.right);
		            q.add(left.right);
		            q.add(right.left);            
		        }
		        return true;
		    }

}
