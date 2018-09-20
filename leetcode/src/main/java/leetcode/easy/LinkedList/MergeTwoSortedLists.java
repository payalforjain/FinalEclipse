package leetcode.easy.LinkedList;

import leetcode.Model.ListNode;

public class MergeTwoSortedLists {

	/*
	Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
	 */
	 public ListNode mergeTwoListsIter(ListNode l1, ListNode l2) {
			 ListNode head = new ListNode(0);
			 ListNode p = head;

			 while (l1 != null || l2 != null) {
				 if (l1 != null && l2 != null) {
					 if (l1.val < l2.val) {
						 p.next = l1;
						 l1 = l1.next;
					 } else {
						 p.next = l2;
						 l2 = l2.next;
					 }
					 p = p.next;
				 } else if (l1 == null) {
					 p.next = l2;
					 break;
				 } else if (l2 == null) {
					 p.next = l1;
					 break;
				 }
			 }

			 return head.next;
		 }
	public ListNode mergeTwoLists(ListNode a, ListNode b) {


		ListNode result = null;

		/* Base cases */
		if (a == null)
			return(b);
		else if (b==null)
			return(a);

		/* Pick either a or b, and recur */
		if (a.val <= b.val)
		{
			result = a;
			result.next =mergeTwoLists(a.next, b);
		}
		else
		{
			result = b;
			result.next = mergeTwoLists(a, b.next);
		}
		return result;

	}

}
