package leetcode.easy.Trees;

import bst.BSTNode;

public class PathSum {

	public BSTNode root;

	public boolean pathSum(int a) {
		return pathSum(root, a);
	}

	public boolean pathSum(BSTNode node, int a) {
		if (node == null)
			return false;
		if (node.getData() == a && node.getLeft() == null && node.getRight() == null)
			return true;
		else
			return pathSum(node.getLeft(), a - node.getData()) || pathSum(node.getRight(), a - node.getData());
	}
}
