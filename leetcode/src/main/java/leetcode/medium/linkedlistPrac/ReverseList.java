package leetcode.medium.linkedlistPrac;

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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;

            if (next != null) {
                next = next.next;
            }
        }

        return prev;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args)
    {
        ReverseList r = new ReverseList();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        r.reverseList(head1);
    }
}
