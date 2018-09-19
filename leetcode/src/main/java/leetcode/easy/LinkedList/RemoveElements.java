package leetcode.easy.LinkedList;

import leetcode.Model.ListNode;

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
