package Microsoft;

import leetcode.Model.TreeNode;

public class ConstructBinaryTreeFromOther {

    /*
    Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
     */



    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length) return null;
        int n = preorder.length;
        return buildBT(preorder, inorder, 0, n-1, 0, n-1);
    }

    TreeNode buildBT(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = -1; // root index in inorder
        for(int i=inStart; i<=inEnd; i++) {
            if(inorder[i]==root.val) {
                rootIndex = i;
            }
        }
        if(rootIndex==-1) return null;
        int leftTreeSize = rootIndex - inStart;
        int rightTreeSize = inEnd - rootIndex;

        root.left = buildBT(preorder, inorder, preStart+1, preStart+leftTreeSize, inStart, rootIndex-1);
        root.right = buildBT(preorder, inorder, preEnd-rightTreeSize+1, preEnd, rootIndex+1, inEnd);
        return root;
    }


    public static void main(String[] args)
    {
        ConstructBinaryTreeFromOther c = new ConstructBinaryTreeFromOther();
        int[] preorder = {3,9,20,15,7};
        int[] postOrder = {9,3,15,20,7};
        c.buildTree(preorder  , postOrder);
    }

    /*
    106. Construct Binary Tree from Inorder and Postorder Traversal
Medium
629
15


Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
     */


    public TreeNode buildTrePost(int[] inorder, int[] postorder) {
        if(inorder.length!=postorder.length) return null;
        int n = inorder.length;
        return buildBT(inorder, postorder, 0, n-1, 0, n-1);
    }

    TreeNode buildBTPost(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart>inEnd || postStart>postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = -1;
        for(int i=inStart; i<=inEnd; i++) {
            if(inorder[i]==root.val) {
                rootIndex = i;
                break;
            }
        }
        if(rootIndex==-1) return null;
        int leftTreeSize = rootIndex - inStart;
        int rightTreeSize = inEnd - rootIndex;

        root.left = buildBTPost(inorder, postorder, inStart, rootIndex-1, postStart, postStart+leftTreeSize-1);
        root.right = buildBTPost(inorder, postorder, rootIndex+1, inEnd, postEnd-rightTreeSize, postEnd-1);
        return root;
    }
}
