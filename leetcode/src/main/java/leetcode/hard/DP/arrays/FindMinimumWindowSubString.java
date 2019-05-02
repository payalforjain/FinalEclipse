package leetcode.hard.DP.arrays;
import java.util.*;

public class FindMinimumWindowSubString {
/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
    /*
   1. Use two pointers: start and end to represent a window.
2. Move end to find a valid window.
3. When a valid window is found, move start to find a smaller window.
*/
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap(); //<char, count of char in t>
        int start = 0, end = 0; //two pointers, one point to tail and one  head
        int minStart = 0;//track the start pos of min string
        int minLen = Integer.MAX_VALUE; //the length of min string
        int counter = t.length(); // counter represents the number of chars of t to be found in s.
        /* initialize the hash map here */
        for(char c:s.toCharArray())map.put(c,0);
        for(char c:t.toCharArray()){
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                return "";
        }
        while(end < s.length()){
            char cur = s.charAt(end);
            /* modify counter here */
            if(map.get(cur)>0) counter --;//if cur is in t
            map.put(cur, map.get(cur) - 1);
            /* counter condition --find a valid window */
            while(counter == 0){
                /* update minLen here if finding minimum*/
                if(minLen > end - start + 1){
                    minStart = start;
                    minLen = end - start + 1;
                }
                //set back map and counter & move forwards start till invalid
                /*modify counter here*/
                char c2 = s.charAt(start);
                map.put(c2, map.get(c2) + 1);
                if(map.get(c2) > 0)counter++;//set counter back only for char in t
                start++;
            }
            end++;
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(minStart, minStart+minLen);
    }
}
