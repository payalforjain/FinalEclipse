package leetcode.medium.string;

public class StringCompression {
/*
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 */
    public int compress(char[] chars) {
        final int limit = chars.length - 1;
        int writeIdx = 0, anchorIdx = 0;

        for(int readIdx = 0; readIdx < chars.length; readIdx++) {
            if(readIdx == limit || chars[readIdx] != chars[readIdx + 1]) {
                chars[writeIdx++] = chars[anchorIdx];

                if(readIdx > anchorIdx) {
                    for(char c : ("" + (readIdx - anchorIdx + 1)).toCharArray()) {
                        chars[writeIdx++] = c;
                    }
                }

                anchorIdx = readIdx + 1;
            }
        }

        return writeIdx;
    }
}
