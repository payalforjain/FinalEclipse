package leetcode.medium.arrays;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
 */


    public class KthLargest {
        // small will be the first to be deleted
        private PriorityQueue<Integer> q;
        private int size;

        public KthLargest(int k, int[] nums) {
            q = new PriorityQueue<>();
            size = k;

            for (int i=0;i<nums.length;i++){
                add(nums[i]);
            }
        }

        public int add(int val) {
            if (q.size() < size) {
                q.add(val);
            } else if (q.peek() < val) {
                q.poll();
                q.add(val);
            }
            return q.peek();
        }

        public static  void main(String[] args)
        {
            int k = 3;
            int[] arr = {4,5,8,2};
            KthLargest kthLargest = new KthLargest(3, arr);
            kthLargest.add(4);
        }

    }





