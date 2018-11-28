package leetcode.medium.Trees;
import leetcode.Model.TreeNode;
import java.util.*;
public class SubTree {

/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 */
	HashSet < String > trees = new HashSet < > ();
	public boolean isSubtreeIter(TreeNode s, TreeNode t) {
		String tree1 = preorder(s, true);
		String tree2 = preorder(t, true);
		return tree1.indexOf(tree2) >= 0;
	}
	public String preorder(TreeNode t, boolean left) {
		if (t == null) {
			if (left)
				return "lnull";
			else
				return "rnull";
		}
		return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		return traverse(s,t);
	}
	public boolean equals(TreeNode x,TreeNode y)
	{
		if(x==null && y==null)
			return true;
		if(x==null || y==null)
			return false;
		return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
	}
	public boolean traverse(TreeNode s,TreeNode t)
	{
		return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
	}

}
