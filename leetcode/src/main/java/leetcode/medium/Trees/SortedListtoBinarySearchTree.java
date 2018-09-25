package leetcode.medium.Trees;
import leetcode.Model.TreeNode;
import leetcode.Model.ListNode;
public class SortedListtoBinarySearchTree {

    /*
    Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
     */
   // Time Complexity - O(n)，Space Complexity - O(n)
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        int listSize = 0;
        current = head;
        ListNode node = head;

        while(node != null) {
            node = node.next;
            listSize++;
        }

        return sortedListToBST(listSize);
    }

    private TreeNode sortedListToBST(int listSize) {  // in-order traversal
        if(listSize <= 0)
            return null;
        TreeNode left = sortedListToBST(listSize / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBST(listSize - 1 - listSize / 2);
        root.left = left;
        root.right = right;
        return root;
    }


//Time Complexity - O(nlogn)，Space Complexity - O(n)
    public TreeNode sortedListToBSTBetter(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = (head != slow) ? sortedListToBSTBetter(head) : null;
        root.right = sortedListToBSTBetter(slow.next);
        return root;
    }
}
