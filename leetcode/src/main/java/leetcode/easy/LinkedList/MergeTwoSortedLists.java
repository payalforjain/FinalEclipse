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


		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null) cur.next = l1;
		if (l2 != null) cur.next = l2;
		return dummy.next;
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
