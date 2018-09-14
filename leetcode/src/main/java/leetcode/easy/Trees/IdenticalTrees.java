package leetcode.easy.Trees;

public class IdenticalTrees {
	//Two binary trees are considered the same if they have identical structure and nodes have the same value
	public boolean isSameTree(TreeNode p, TreeNode q) {
	    if(p==null && q==null){
	        return true;
	    }else if(p==null || q==null){
	        return false;
	    }
	 
	    if(p.val==q.val){
	        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	    }else{
	        return false;
	    }
	}

}
