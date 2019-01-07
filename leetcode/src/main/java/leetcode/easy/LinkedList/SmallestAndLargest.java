package leetcode.easy.LinkedList;

import leetcode.Model.ListNode;
public class SmallestAndLargest {

    int largestElement(ListNode head)
    {
        // Declare a max variable and initialize
        // it with INT_MIN value.
        // INT_MIN is integer type and its value
        // is -32767 or less.
        int max = Integer.MIN_VALUE;

        // Check loop while head not equal to NULL
        while (head != null) {

            // If max is less then head->data then
            // assign value of head->data to max
            // otherwise node point to next node.
            if (max < head.val)
                max = head.val;
            head = head.next;
        }
        return max;
    }

    // Function that returns smallest element
// from the linked list.
    int smallestElement(ListNode head)
    {
        // Declare a min variable and initialize
        // it with INT_MAX value.
        // INT_MAX is integer type and its value
        // is 32767 or greater.
        int min = Integer.MAX_VALUE;

        // Check loop while head not equal to NULL
        while (head != null) {

            // If min is greater then head->data then
            // assign value of head->data to min
            // otherwise node point to next node.
            if (min > head.val)
                min = head.val;

            head = head.next;
        }
        return min;
    }
}
