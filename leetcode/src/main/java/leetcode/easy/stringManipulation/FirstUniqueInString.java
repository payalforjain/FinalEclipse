package leetcode.easy.stringManipulation;
import java.util.*;
public class FirstUniqueInString {

/*
given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 */

   // Improved version, which checks early termination when all characters from 'a'~'z' appear more than twice. (18 ms)
    public int firstUniqChar2(String s) {
        if (s==null || s.length()==0) return -1;
        int len = s.length();
        char[] cc = s.toCharArray();
        int slow =0, fast=1;
        int[] count = new int[256];
        int total = 0;
        count[cc[slow]]++;
        while (fast < len) {
            count[cc[fast]]++;
            if (cc[fast] == cc[slow]) {
                total++;
                if (total==26) return -1;
                while (slow < len && count[cc[slow]] > 1) slow++;
                if (slow >= len) return -1;
            }
            if (count[cc[slow]]==0) count[cc[slow]]++;
            if (slow > fast) fast=slow;
            fast++;
        }
        return slow;
    }

/*
    LinkedHashMap will not be the fastest answer for this question because the
    input characters are just from 'a' to 'z', but in other situations it might be faster than two pass solutions. I post this just for inspiration.*/

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (map.get(s.charAt(i)) != null) {// no need to check
                    map.remove(s.charAt(i));
                }
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }

}
