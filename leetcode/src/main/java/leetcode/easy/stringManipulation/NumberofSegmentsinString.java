package leetcode.easy.stringManipulation;

public class NumberofSegmentsinString {

    /*
    Time complexity : O(n)O(n)

We do a constant time check for each of the string's nn indices, so the runtime is overall linear.

Space complexity : O(1)O(1)

There are only a few integers allocated, so the memory footprint is constant.
     */
    public int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }

    /*
    Time complexity : O(n)O(n)

We do a constant time check for each of the string's nn indices, so the runtime is overall linear.

Space complexity : O(1)O(1)

There are only a few integers allocated, so the memory footprint is constant.
     */

    public int countSegmentsBuiltin(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }

    /*
    Time complexity : O(n)O(n)

All builtin language functionality used here (in both the Java and Python examples) runs in either O(n)O(n) or O(1)O(1) time, so the entire algorithm runs in linear time.

Space complexity : O(n)O(n)

split (in both languages) returns an array/list of O(n)O(n) length, so the algorithm uses linear additional space.
     */

}
