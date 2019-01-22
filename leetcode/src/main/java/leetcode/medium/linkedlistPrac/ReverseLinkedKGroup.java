package leetcode.medium.linkedlistPrac;

import leetcode.Model.ListNode;

public class ReverseLinkedKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode p = head;
        int counter = 0;

        while( p!= null)
        {
            counter++;

            if(counter % k == 0)
            {
                pre = reverse(pre , p.next);
                p = pre.next;
            }
            else
            {
                p = p.next;
            }

        }


        return dummyNode.next;
    }

    public ListNode reverse(ListNode pre, ListNode end) {

        ListNode head = pre.next;
        ListNode cur = head.next;

        while(cur != end)
        {
            ListNode temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
        }

        head.next = end;
        return head;
    }
    public static void main(String[] args)
    {
        ReverseLinkedKGroup r = new  ReverseLinkedKGroup();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        r.reverseKGroup(head1,3);
    }
}
