package leetcode.easy.LinkedList;

import leetcode.Model.ListNode;

public class RemoveNthNodeFromList {
	/*
	Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
	 */
	
	/*(Use fast and slow pointers. The fast pointer is n steps ahead of the slow pointer. 
	When the fast reaches the end, the slow pointer points at the previous element of the target element.
   */
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    if(head == null)
	        return null;
	 
	    ListNode fast = head;
	    ListNode slow = head;
	 
	    for(int i=0; i<n; i++){
	        fast = fast.next;
	    }
	 
	    //if remove the first node
	    if(fast == null){
	        head = head.next;
	        return head;
	    }
	 
	    while(fast.next != null){
	        fast = fast.next;
	        slow = slow.next;
	    }
	 
	    slow.next = slow.next.next;
	 
	    return head;
	}

	void printNthFromLast(ListNode head,int n)
	{
		ListNode main_ptr = head;
		ListNode ref_ptr = head;

		int count = 0;
		if (head != null)
		{
			while (count < n)
			{
				if (ref_ptr == null)
				{
					System.out.println(n+" is greater than the no "+
							" of nodes in the list");
					return;
				}
				ref_ptr = ref_ptr.next;
				count++;
			}
			while (ref_ptr != null)
			{
				main_ptr = main_ptr.next;
				ref_ptr = ref_ptr.next;
			}
			System.out.println("Node no. "+n+" from last is "+
					main_ptr.val);
		}
	}
}
