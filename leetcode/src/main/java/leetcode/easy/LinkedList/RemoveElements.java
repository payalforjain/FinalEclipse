package leetcode.easy.LinkedList;

import leetcode.Model.ListNode;
/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */
public class RemoveElements {
	public ListNode removeElements(ListNode head, int val) {
	    ListNode helper = new ListNode(0);
	    helper.next = head;
	    ListNode p = helper;
	 
	    while(p.next != null){
	        if(p.next.val == val){
	            ListNode next = p.next;
	            p.next = next.next; 
	        }else{
	            p = p.next;
	        }
	    }
	 
	    return helper.next;
	}
}
