package leetcode.medium.arrays;
import java.util.*;
public class MeetingRooms {


    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    private class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
        return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
    }
}

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new IntervalComparator());

        for(int i = 0; i < intervals.length-1; i++)
        {
            if(intervals[i] . end  > intervals[i+1] . start)
            {
                return false;
            }
        }
        return true;
    }

    /*

    Complexity Analysis

Time complexity : O(n \log n)O(nlogn). The time complexity is dominated by sorting. Once the array has been sorted, only O(n)O(n) time is taken to go through the array and determine if there is any overlap.

Space complexity : O(1)O(1). Since no additional space is allocated.
     */
}
