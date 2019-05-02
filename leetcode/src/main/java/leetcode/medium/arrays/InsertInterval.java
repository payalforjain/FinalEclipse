package leetcode.medium.arrays;
import java.util.*;
public class InsertInterval
{

    /*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

     */
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> res = new ArrayList<Interval>();

            for(Interval each: intervals){
                if(each.end < newInterval.start){

                    res.add(each);
                }else if(each.start > newInterval.end){
                    res.add(newInterval);
                    newInterval = each;
                }else if(each.end >= newInterval.start || each.start <= newInterval.end){
                    int nstart = Math.min(each.start, newInterval.start);
                    int nend = Math.max(newInterval.end, each.end);
                    newInterval = new Interval(nstart, nend);
                }
            }

            res.add(newInterval);

            return res;
        }


    public List<Interval> insertBin(List<Interval> intervals, Interval newInterval) {
        /**
         * Since the original list is sorted and all intervals are disjoint,
         * apply binary search to find the insertion index for the new
         * interval. [LC35]
         *
         * 1. Find insIdx=the insertion index of new.start, i.e., the first
         * index i such that list.get(i).start>=new.start.
         *
         * 2. Find nxtIdx=the insertion index of new.end, i.e., the first
         * index i such that list.get(i).end>=new.end.
         *
         * 3. Remove all elements of the list with indices insIdx<=i<nxtIdx.
         *
         * 4. Merge new with list.get(insIdx-1) or list.get(nxtIdx) or both.
         */

        int n = intervals.size();
        if (n == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        int low = 0, high = n - 1, mid = 0;
        int temp, target = newInterval.start;
        while (low <= high) {
            mid = (low + high) / 2;
            temp = intervals.get(mid).start;
            if (temp == target)
                break;
            if (temp < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        // insIdx = the index where new interval to be inserted
        int insIdx = (low <= high) ? mid : low;
        Interval pre = (insIdx == 0) ? null : intervals.get(insIdx - 1);
        // 0<=insIdx<=n, pre=[insIdx-1], pre.start<new.start

        low = insIdx;
        high = n - 1;
        target = newInterval.end;
        while (low <= high) {
            mid = (low + high) / 2;
            temp = intervals.get(mid).end;
            if (temp == target)
                break;
            if (temp < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        // nxtIdx= the next index after the inserted new interval
        int nxtIdx = (low <= high) ? mid : low;
        Interval nxt = (nxtIdx == n) ? null : intervals.get(nxtIdx);
        // insIdx<=nxtIdx<=n, nxt=[nxtIdx], nxt.end>=new.end

        // [0]...[insIdx-1] <--> [insIdx]...[nxtIdx-1][nxtIdx]...[n]
        intervals.subList(insIdx, nxtIdx).clear();

        // check whether newInterval can be merged with pre or nxt
        boolean isMerged = false, isMerged2 = false;
        if (insIdx > 0 && pre.end >= newInterval.start) {
            pre.end = Math.max(pre.end, newInterval.end);
            isMerged = true;
        }

        if (nxtIdx < n && newInterval.end >= nxt.start) {
            nxt.start = Math.min(nxt.start, newInterval.start);
            isMerged2 = isMerged;
            isMerged = true;
        }

        if (!isMerged) {
            intervals.add(insIdx, newInterval);
            return intervals;
        }

        // merged with pre or nxt or both, deal with the both case
        if (isMerged2 && pre.end >= nxt.start) {
            nxt.start = pre.start; // pre.start < new.start, nxt.start;
            intervals.remove(insIdx - 1); // remove pre
        }

        return intervals;
    }
}
