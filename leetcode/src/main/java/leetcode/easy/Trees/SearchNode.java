package leetcode.easy.Trees;

public class SearchNode {

	public BSTNode root;

	public boolean search(int data) {
		return search(root, data);
	}

	public boolean search(BSTNode node, int data) {

		if (node == null)
			return false;
		else if (node.getData() == data) {

			return true;
		} else if (node.getData() > data) {

			return search(node.getLeft(), data);
		}

		else if (node.getData() < data) {

			return search(node.getRight(), data);
		}

		return true;

	}

	public boolean searchIter(int data) {
		return searchIter(root, data);
	}

	public boolean searchIter(BSTNode node, int data) {

		while (node != null) {

			if (node.getData() > data) {

				node = node.getLeft();
			}

			else if (node.getData() < data) {

				node = node.getRight();
			}

			else if (node.getData() == data) {

				return true;
			}
		}

		return false;

	}

}
