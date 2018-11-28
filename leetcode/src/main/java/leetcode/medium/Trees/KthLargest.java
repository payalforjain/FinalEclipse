package leetcode.medium.Trees;

import leetcode.Model.TreeNode;

public class KthLargest {
    private static int counter;
    private TreeNode findKthLargestItem(TreeNode rootNode, int k) {
        if (rootNode == null) {
            return null;
        }

        //Instead of Left to Right, we will traverse in Right to Left fashion because largest element
        //are present of Right side of Root Node.
        TreeNode node = findKthLargestItem(rootNode.right, k);

        //If counter is not equal to K, then only increment the counter.
        //Once counter is equal to K, it means we have found the desired largest element and no need to increment further,
        //Take the back up of the current node as it might be the Kth largest element we are looking for.
        if (counter != k) {
            counter++;
            node = rootNode;
        }

        //This is the place where actual check is going to happen between counter and K,
        //If counter matched K, it means we found the node and no need to find further so simply return the found node.
        if (counter == k) {
            return node;
        } else
            return findKthLargestItem(rootNode.left, k);
    }



}
