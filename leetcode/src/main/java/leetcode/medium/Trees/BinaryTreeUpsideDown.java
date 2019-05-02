package leetcode.medium.Trees;

import leetcode.Model.TreeNode;

public class BinaryTreeUpsideDown {

    /*
    Input: [1,2,3,4,5]

    1
   / \
  2   3
 / \
4   5

Output: return the root of the binary tree [4,5,2,#,#,3,1]

   4
  / \
 5   2
    / \
   3   1
Clarification:

Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ.

The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:

   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].
     */

    /*
    right becomes left
    left becomes root
    root becomes right
     */

    /*
    Iteration: Time ~ O(N), Space ~ O(1)
  Top-down
  */

    public TreeNode upsideDownBinaryTreeIter(TreeNode root) {
        TreeNode node = root, parent = null, right = null;
        while (node != null) {
            TreeNode left = node.left;
            node.left = right;
            right = node.right;
            node.right = parent;
            parent = node;
            node = left;
        }
        return parent;
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode left = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return left;
    }
public static void main(String[] args)
{
    BinaryTreeUpsideDown b = new BinaryTreeUpsideDown();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    b.upsideDownBinaryTree(root);
}
}
