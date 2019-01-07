package leetcode.easy.LinkedList;

import leetcode.Model.ListNode;

public class RotateList {

    /*
    Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
     */

    /*
 - find out how many times to rotate: k%len
           - each time, do rotate operation by moving last node in list to the new head
           - edge case: len = 1 */
   /*

Complexity: Time O(k%len*N) ~ O(N) Space O(1)*/

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode cur = head;
        int len =0 ;
        while(cur != null)
        {
            cur =cur.next;
            len++;
        }

        int noOfTimes = k % len;

        ListNode nHead = head;


        for(int i =0 ; i<noOfTimes;i++ )
        {

            nHead = doRotation( nHead);
        }


        return nHead;

    }
    public ListNode doRotation(ListNode head)
    {
        ListNode cur = head;
        while(cur.next != null && cur.next.next != null)
        {
            cur = cur.next;
        }

        ListNode nHead = cur.next;
        cur.next = cur.next.next;
        nHead.next=head;

        return nHead;
    }
}
