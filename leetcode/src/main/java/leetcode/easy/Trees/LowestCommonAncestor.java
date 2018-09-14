package leetcode.easy.Trees;

public class LowestCommonAncestor {
	protected BSTNode root;

	public BSTNode findLca(int t1, int t2) {
		return findLca(root, t1, t2);
	}

	public BSTNode findLca(BSTNode node, int t1, int t2) {
		if (node == null)
			return null;

		if (t1 < node.getData() && t2 < node.getData())// both targets are left
			return findLca(node.getLeft(), t1, t2);
		else if (t1 > node.getData() && t2 > node.getData()) // both targets are
																// right
			return findLca(node.getRight(), t1, t2);
		else {

			System.out.println(node.getData());
			return node;
		}
	}

	BSTNode nonfirstCommonAncestor(int data1, int data2) {
		return nonfirstCommonAncestor(root, data1, data2);
	}

	BSTNode nonfirstCommonAncestor(BSTNode node, int data1, int data2) {

		while (node != null) {

			if (data1 > node.getData() && data2 > node.getData()) {
				node = node.getRight();
			}

			else if (data1 < node.getData() && data2 < node.getData()) {
				node = node.getLeft();
			}

			else {
				System.out.println(node.getData());
				return node;
			}
		}
		return node;
	}

}
