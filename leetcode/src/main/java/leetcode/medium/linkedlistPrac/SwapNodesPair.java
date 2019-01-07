package leetcode.medium.linkedlistPrac;

import leetcode.Model.ListNode;

public class SwapNodesPair {
    public ListNode swapPairs(ListNode head) {
             ListNode dummy = new ListNode(-1);
             ListNode pre = dummy;
             ListNode cur = pre.next;

             while(cur != null && cur.next != null)
             {
                 pre.next = cur.next;
                 cur.next = cur.next.next;
                 pre.next.next = cur ;
                 pre = cur;
                 cur = pre.next;
             }

             return dummy.next;
    }
}
