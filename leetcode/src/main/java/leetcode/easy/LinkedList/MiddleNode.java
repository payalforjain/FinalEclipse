package leetcode.easy.LinkedList;
import leetcode.Model.ListNode;
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /*
    Time Complexity: O(N)O(N), where NN is the number of nodes in the given list.

Space Complexity: O(1)O(1), the space used by slow and fast
     */
}
