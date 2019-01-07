package leetcode.easy.LinkedList;

import leetcode.Model.ListNode;

public class Intersection {
	
	/*Write a program to find the node at which the intersection of two singly linked lists begins.


	For example, the following two linked lists:

	A:          a1 → a2
	                   ↘
	                     c1 → c2 → c3
	                   ↗            
	B:     b1 → b2 → b3*/

	/*

	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB)
	{
		if (headA == null || headB == null)
		{
			return null;
		}

		// get the tail of list A.
		ListNode node = headA;
		while (node.next != null)
		{
			node = node.next;
		}
		node.next = headB;
		ListNode result = detectCycle(headA);
		node.next = null;
		return result;
	}

	public ListNode detectCycle(ListNode head) {
		boolean hasCycle = false;
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
			{
				hasCycle = true;
				break;
			}

		}
		if (!hasCycle) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
