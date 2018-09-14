package leetcode.medium.linkedlistPrac;

import java.util.Stack;

public class AddTwoNumbers {
	/*
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The digits are stored in reverse order and each of their nodes
	 * contain a single digit. Add the two numbers and return it as a linked
	 * list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except
	 * the number 0 itself.
	 * 
	 * Example
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342
	 * + 465 = 807.
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode first, ListNode second) {
		ListNode res = null; // res is head node of the resultant list
		ListNode prev = null;
		ListNode temp = null;
		int carry = 0, sum;

		while (first != null || second != null) // while both lists exist
		{
			// Calculate value of next digit in resultant list.
			// The next digit is sum of following things
			// (i) Carry
			// (ii) Next digit of first list (if there is a next digit)
			// (ii) Next digit of second list (if there is a next digit)
			sum = carry + (first != null ? first.val : 0) + (second != null ? second.val : 0);

			// update carry for next calulation
			carry = (sum >= 10) ? 1 : 0;

			// update sum if it is greater than 10
			sum = sum % 10;

			// Create a new node with sum as data
			temp = new ListNode(sum);

			// if this is the first node then set it as head of
			// the resultant list
			if (res == null) {
				res = temp;
			} else // If this is not the first node then connect it to the rest.
			{
				prev.next = temp;
			}

			// Set prev for next insertion
			prev = temp;

			// Move first and second pointers to next nodes
			if (first != null) {
				first = first.next;
			}
			if (second != null) {
				second = second.next;
			}
		}

		if (carry > 0) {
			temp.next = new ListNode(carry);
		}

		// return head of the resultant list
		return res;
	}
	/* Utility function to print a linked list */

	void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println("");
	}

	/*
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The most significant digit comes first and each of their nodes
	 * contain a single digit. Add the two numbers and return it as a linked
	 * list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except
	 * the number 0 itself.
	 * 
	 * Follow up: What if you cannot modify the input lists? In other words,
	 * reversing the lists is not allowed.
	 * 
	 * Example:
	 * 
	 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
	 */
	public ListNode addTwoNumbersSecond(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		} else if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}

		Stack<ListNode> result = new Stack<ListNode>();
		Stack<ListNode> s1 = new Stack<ListNode>();
		Stack<ListNode> s2 = new Stack<ListNode>();

		while (l1 != null) {
			s1.push(l1);
			l1 = l1.next;
		}

		while (l2 != null) {
			s2.push(l2);
			l2 = l2.next;
		}

		int carrier = 0;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			int sum = 0;
			if (!s1.isEmpty() && !s2.isEmpty()) {
				sum += s1.pop().val + s2.pop().val;
			} else if (!s1.isEmpty()) {
				sum += s1.pop().val;
			} else {
				sum += s2.pop().val;
			}
			result.push(new ListNode((sum + carrier) % 10));// 2, 1, 9
			carrier = (sum + carrier) / 10; // 12/10 = 1; 11/10 = 1; (8+1)/ 10 =
			// 0
		}
		if (carrier == 1) {
			result.push(new ListNode(carrier));
		}

		// return results:
		ListNode node = new ListNode(0);
		ListNode dummy = node;
		while (!result.isEmpty()) {// 219
			node.next = result.pop();
			node = node.next;
		}

		return dummy.next;
	}
}
