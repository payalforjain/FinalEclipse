package leetcode.easy.LinkedList;

import leetcode.Model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
/*

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return true;
		}

		return false;
	}

	public boolean hasCycleExtraSpace(ListNode head) {
		Set<ListNode> nodesSeen = new HashSet<>();
		while (head != null) {
			if (nodesSeen.contains(head)) {
				return true;
			} else {
				nodesSeen.add(head);
			}
			head = head.next;
		}
		return false;
	}

	/**
	 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

	 Note: Do not modify the linked list.

	 Follow up:
	 Can you solve it without using extra space?


	 */
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
