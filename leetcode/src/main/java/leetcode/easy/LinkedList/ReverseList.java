package leetcode.easy.LinkedList;

import leetcode.Model.ListNode;

public class ReverseList {
    /*
    Initialize three pointers prev as NULL, curr as head and next as NULL.
Iterate trough the linked list. In loop, do following.
// Before changing next of current,
// store next node
next = curr->next
// Now change next of current
// This is where actual reversing happens
curr->next = prev

// Move prev and curr one step forward
prev = curr
curr = next
     */
   /*  Given linked list
85 15 4 20
    Reversed Linked list
20 4 15 85
    Time Complexity: O(n)
    Space Complexity: O(1)*/
    public ListNode reverseListIter(ListNode head) {
        if(head==null||head.next==null)
            return head;

        ListNode p1 = head;
        ListNode p2 = p1.next;

        head.next = null;
        while(p1!=null&& p2!=null){
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        return p1;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null)
            return head;

        //get second node
        ListNode second = head.next;
        //set first's next to be null
        head.next = null;

        ListNode rest = reverseList(second);
        second.next = head;

        return rest;
    }
}
