package leetcode.easy.Trees;

import java.util.LinkedList;
import java.util.List;

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

		List<String> paths = new LinkedList<>();

		if (root == null)
			return paths;

		if (root.left == null && root.right == null) {
			paths.add(root.val + "");
			return paths;
		}

		for (String path : binaryTreePaths(root.left)) {
			paths.add(root.val + "->" + path);
		}

		for (String path : binaryTreePaths(root.right)) {
			paths.add(root.val + "->" + path);
		}

		return paths;
	}

}
