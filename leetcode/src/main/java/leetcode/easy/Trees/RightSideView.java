package leetcode.easy.Trees;

import java.util.*;

public class RightSideView {
/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom. For example, given the following binary tree,

   1            <---
 /   \
2     3         <---
 \
  5             <---
You can see [1, 3, 5].
 */
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            //get size here
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
//the first element in the queue (right-most of the tree)
                if (i == 0) {
                    result.add(top.val);
                }
//add right first
                if (top.right != null) {
                    queue.add(top.right);
                }
//add left
                if (top.left != null) {
                    queue.add(top.left);
                }
            }
        }
        return result;
    }

    public List<Integer> leftSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            //get size here
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.remove();
//the first element in the queue (right-most of the tree)
                if (i == 0) {
                    result.add(top.val);
                }
//add left first
                if (top.left != null) {
                    queue.add(top.left);
                }
//add right
                if (top.right != null) {
                    queue.add(top.right);
                }


            }
        }
        return result;
    }
public static void main(String[] args)
{
    TreeNode root = new TreeNode(12);

    root.left = new  TreeNode(10);
    root.right = new  TreeNode(30);
    root.right.left = new  TreeNode(25);
    root.right.right = new  TreeNode(40);

    RightSideView rightSideView = new RightSideView();
    rightSideView.leftSideView(root);

}


}
