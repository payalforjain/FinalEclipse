package leetcode.medium.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {

    /*
 Example 1:

 Input: [[0, 30],[5, 10],[15, 20]]
 Output: 2
 Example 2:

 Input: [[7,10],[2,4]]
 Output: 1

 Time Complexity: O(NlogN)O(NlogN).

There are two major portions that take up time here. One is sorting of the array that takes O(NlogN)O(NlogN) considering that the array consists of NN elements.
Then we have the min-heap. In the worst case, all NN meetings will collide with each other. In any case we have NN add operations on the heap. In the worst case we will have NN extract-min operations as well. Overall complexity being (NlogN)(NlogN) since extract-min operation on a heap takes O(logN)O(logN).
Space Complexity: O(N)O(N) because we construct the min-heap and that can contain NN elements in the worst case as described above in the time complexity section. Hence, the space complexity is O(N)O(N).



  */
    //https://leetcode.com/problems/meeting-rooms-ii/Figures/253/253_Meeting_Rooms_II_Diag_4.png
/*
    static Interval[] intervals = new Interval[3];
    {
        Interval a = new Interval (0,30);
        Interval b = new Interval (5,10);
        Interval c = new Interval (15,20);
        intervals[0] = a;
        intervals[1] = b;
        intervals[2] = c;
    }
    public static void main(String[] args)
    {

        MeetingRooms m = new MeetingRooms();
        m.minMeetingRooms(intervals);

    }
    */
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null||intervals.length==0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval t1, Interval t2) {
                if(t1.start != t2.start)
                    return t1.start - t2.start;
                else
                    return t1.end - t2.end;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int count=1;
        queue.offer(intervals[0].end);

        for(int i=1; i<intervals.length; i++){
            if(intervals[i].start<queue.peek()){
                count++;

            }else{
                queue.poll();
            }

            queue.offer(intervals[i].end);
        }

        return count;
    }
    public static void main(String[] args)
    {

        MeetingRoom2  m = new  MeetingRoom2 ();
        m.minMeetingRooms(intervals);


    }

    static Interval[] intervals = new Interval[3];
    {
        Interval  a = new Interval(9,10);
        Interval b = new Interval(4,9);
        Interval c = new Interval(4,7);
        intervals[0] = a;
        intervals[1] = b;
        intervals[2] = c;
    }
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

}
