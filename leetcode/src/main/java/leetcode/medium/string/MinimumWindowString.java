package leetcode.medium.string;

import java.util.HashMap;

public class MinimumWindowString {

    public static void main(String[] args) {
        MinimumWindowString m = new MinimumWindowString();
        m.minWindow("ADOBECODEBANC", "ABC");
    }

    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> dictionary = new HashMap<Character, Integer>();

        for (int i = 0; i < T.length(); i++) {
            map.put(T.charAt(i), 0);

            if (dictionary.containsKey(T.charAt(i))) {
                dictionary.put(T.charAt(i), dictionary.get(T.charAt(i)) + 1);
            } else {
                dictionary.put(T.charAt(i), 1);
            }
        }

        int start = 0;
        int count = 0;
        int minLen = S.length() + 1;
        String result = "";

        for (int end = 0; end < S.length(); end++) {
            if (map.containsKey(S.charAt(end))) {
                map.put(S.charAt(end), map.get(S.charAt(end)) + 1);

                if (map.get(S.charAt(end)) <= dictionary.get(S.charAt(end))) {
                    count++;
                }
            }
            if (count == T.length()) {
                while (!dictionary.containsKey(S.charAt(start)) || map.get(S.charAt(start)) > dictionary.get(S.charAt(start))) {
                    if (map.containsKey(S.charAt(start))) {
                        map.put(S.charAt(start), map.get(S.charAt(start)) - 1);
                    }
                    start++;
                }

                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    result = S.substring(start, end + 1);
                }
            }
        }

        return result;
    }
}
