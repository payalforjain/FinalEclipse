import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode retHead = new ListNode(0);
        ListNode retCurr = retHead;
        int i1, i2;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                retCurr.next = l2;
                break;
            }
            if (l2 == null) {
                retCurr.next = l1;
                break;
            }
            i1 = l1.val;
            i2 = l2.val;
            if (i1 > i2) {
                retCurr.next = l2;
                l2 = l2.next;
            } else {
                retCurr.next = l1;
                l1 = l1.next;
            }
            retCurr = retCurr.next;
        }
        retHead = retHead.next;
        return retHead;
    }
    public ListNode mergeKLists(List<ListNode> lists) {
        ArrayDeque<ListNode> ret = new ArrayDeque<ListNode>();
        ListNode l1, l2;
        int n = lists.size();
        if (n == 0) {
            return null;
        }
        for (ListNode e : lists) {
            if (e != null) {
                ret.add(e);
            }
        }
        while (ret.size() > 1) {
            l1 = ret.poll();
            l2 = ret.poll();
            ret.offer(this.mergeTwoLists(l1, l2));
        }
        return ret.poll();
    }
    public void printList(ListNode e) {
        while (e != null) {
            System.out.println(e.val);
            e = e.next;
        }
    }
    public ListNode mergeKListsSolution2(List<ListNode> lists) {
        if (lists.size() == 0)
            return null;

        //PriorityQueue is a sorted queue
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
        new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return Integer.compare(a.val, b.val);
            }
        });

        //add first node of each list to the queue
        for (ListNode list : lists) {
            if (list != null)
                q.add(list);
        }

        ListNode head = new ListNode(0);
        ListNode p = head; // serve as a pointer/cursor

        while (q.size() > 0) {
            ListNode temp = q.poll();
            //poll() retrieves and removes the head of the queue - q.
            p.next = temp;

            //keep adding next element of each list
            if (temp.next != null)
                q.add(temp.next);

            p = p.next;
        }

        return head.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        Solution s = new Solution();
        ArrayList<ListNode> lists = new ArrayList<ListNode>();
        lists.add(l1);
        lists.add(l2);
        ListNode res = s.mergeKListsSolution2(lists);
        s.printList(res);
    }
}