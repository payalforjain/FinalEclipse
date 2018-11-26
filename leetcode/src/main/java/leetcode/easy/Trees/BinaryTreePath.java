package leetcode.easy.Trees;

import java.util.LinkedList;
import java.util.*;

public class BinaryTreePath {
	/*
	 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		if( root == null)
			return paths;
		String sb = "";
		dfs(root, paths,sb);
		return paths;
	}

	private void dfs(TreeNode root ,  List<String> paths , String sb )
	{

		if(root == null)
			return ;
		sb = sb + "->"+ root.val;
		if(root.left == null && root.right == null)
		{
			paths.add(sb.substring(2));
			sb = "";
		}



		if(root.left != null)
		{
			dfs(root.left, paths, sb);
		}


		if(root.right != null)
		{
			dfs(root.right, paths,sb);
		}

	}

}
