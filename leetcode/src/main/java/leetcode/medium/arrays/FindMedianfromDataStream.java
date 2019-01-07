package leetcode.medium.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.


Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2
 */
public class FindMedianfromDataStream {

    PriorityQueue<Integer> maxHeap;//lower half
    PriorityQueue<Integer> minHeap;//higher half

    public FindMedianfromDataStream(){
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());

        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.remove());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
    }

public static void main(String[] args)
{
    FindMedianfromDataStream f = new FindMedianfromDataStream();
    f.addNum(2);
    f.addNum(3);
    f.addNum(4);
    f.findMedian();
    f.addNum(1);
    f.addNum(2);
    f.findMedian();// -> 1.5
    f.addNum(3);
    f.findMedian();// -> 2
}

/*
First of all, it seems that the best time complexity
we can get for this problem is O(log(n)) of add() and O(1) of getMedian(). This data structure seems highly likely to be a tree.
 */


}
