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

	/*
	Time complexity : O(n + m)O(n+m)

Because exactly one of l1 and l2 is incremented on each loop iteration, the while loop runs for a number of iterations equal to the sum of the lengths of the two lists. All other work is constant, so the overall complexity is linear.

Space complexity : O(1)O(1)
	 */
	public ListNode mergeTwoLists(ListNode p1, ListNode p2) {



		if( p1 == null)
		{
			return p2;
		}
		if (p2 == null)
		{
			return p1;
		}


		if(p1.val <= p2.val)
		{
			p1.next =  mergeTwoLists(p1.next , p2);
			return p1;
		}
		else
		{
			p2.next =  mergeTwoLists(p1 , p2.next);
			return p2;
		}

	}


	/*
	Time complexity : O(n + m)O(n+m)

Because each recursive call increments the pointer to l1 or l2 by one (approaching the dangling null at the end of each list), there will be exactly one call to mergeTwoLists per element in each list. Therefore, the time complexity is linear in the combined size of the lists.

Space complexity : O(n + m)O(n+m)The first call to mergeTwoLists does not return until the ends of both l1 and l2 have been reached, so n + mn+m stack frames consume O(n + m)O(n+m) space.
	 */

}
