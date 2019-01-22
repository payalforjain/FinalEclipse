package leetcode.medium.linkedlistPrac;

import leetcode.Model.ListNode;
import java.util.*;
public class AddTwoNumbers2 {

/*
You are given two non-empty linked lists representing two non-negative integers.
The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */


	ListNode addTwoNumbersStack(ListNode l1, ListNode l2) {
		Stack<Integer> s1  = new Stack<>();
		Stack<Integer> s2  = new Stack<>();
		while (l1 !=null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}
		int carry = 0;
		ListNode res = new ListNode(0);
		while (!s1.empty() || !s2.empty()) {
			if (!s1.empty())
			{
				carry += s1.pop();
			}
			if (!s2.empty())
			{
				carry +=  s2.pop();
			}
			res.val = carry % 10;
			ListNode head = new ListNode(carry / 10);
			head.next = res;
			res = head;
			carry /= 10;
		}
		return res.val == 0 ? res.next : res;
	}

	public ListNode addLists2(ListNode l1, ListNode l2) {
		l1 = reverse(l1);
		l2 = reverse(l2);

		return reverse(addTwoNumbers(l1,l2));
	}

	public ListNode reverse(ListNode l){
		ListNode head = null;

		while (l != null){
			ListNode temp = l.next;
			l.next = head;
			head = l;
			l = temp;
		}

		return head;
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;

		ListNode newHead = new ListNode(0);
		ListNode p1 = l1, p2 = l2, p3 = newHead;

		while (p1 != null || p2 != null) {
			if (p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			}

			if (p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}

			p3.next = new ListNode(carry % 10);
			p3 = p3.next;
			carry /= 10;
		}

		if (carry !=0)
			p3.next = new ListNode(carry);

		return newHead.next;
	}
}