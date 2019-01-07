package Microsoft;

import leetcode.Model.ListNode;

public class Lengthofloopinlinkedlist {

    static int countListNodes( ListNode n)
    {
        int res = 1;
        ListNode temp = n;
        while (temp.next != n)
        {
            res++;
            temp = temp.next;
        }
        return res;
    }

    /* This function detects and counts loop  
    ListNodes in the list. If loop is not there  
    in then returns 0 */

    /*
    Find length of loop in linked list
Write a function detectAndCountLoop() that checks whether
a given Linked List contains loop and if loop is present then returns count of nodes in loop.
For example, loop is present in below linked list and length of loop is 4. If loop is not present, then function should return 0.
     */
    static int countListNodesinLoop( ListNode list)
    {
        ListNode slow_p = list, fast_p = list;

        while (slow_p !=null && fast_p!=null && fast_p.next!=null)
        {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;  
  
        /* If slow_p and fast_p meet at some point  
        then there is a loop */
            if (slow_p == fast_p)
                return countListNodes(slow_p);
        }

        /* Return 0 to indeciate that ther is no loop*/
        return 0;
    }

    static ListNode newListNode(int key)
    {
        ListNode temp = new ListNode(key);

        return temp;
    }

    /* Driver program to test above function*/
    public static void main (String[] args) {
        ListNode head = newListNode(1);
        head.next = newListNode(2);
        head.next.next = newListNode(3);
        head.next.next.next = newListNode(4);
        head.next.next.next.next = newListNode(5);

        /* Create a loop for testing */
        head.next.next.next.next.next = head.next;

        System.out.println( countListNodesinLoop(head));
    }
}
