package leetcode.easy.linkedlistPrac;

public class DetectCycle {

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

	/**
	 * @param head:
	 *            The head of linked list.
	 * @return: You should return the head of the sorted linked list, using
	 *          constant space complexity. /* iven a linked list, return the
	 *          node where the cycle begins. If there is no cycle, return null.
	 * 
	 *          Note: Do not modify the linked list.
	 * 
	 *          Follow up: Can you solve it without using extra space?
	 */
	 public ListNode detectCycle(ListNode head) {
	        boolean hasCycle = false;
	        if (head == null || head.next == null) {
	            return null;
	        }
	        ListNode fast = head.next.next;
	        ListNode slow = head.next;
	        while (fast != null && slow != null) {
	            if (fast.next == null) {
	                hasCycle = false;
	                break;
	            }
	            if (fast == slow) {
	                hasCycle = true;
	                break;
	            }
	            fast = fast.next.next;
	            slow = slow.next;
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
