public class Solution {

    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int star = -1;
        int mark = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                mark = i;
                ++j;
            } else if (star != -1) {
                // rewind
                j = star + 1;
                ++mark;
                i = mark;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }
        return j == p.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b;
        b = s.isMatch("a", "a"); System.out.println(b);
        b = s.isMatch("babbbaabbaaaaabbababaaaabbbbbbbbbbabbaaaabbababbabaa", "**a****a**b***ab***a*bab"); System.out.println(b);
        b = s.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"); System.out.println(b);
        b = s.isMatch("babbabbabaaaaabaabaaaaabbabaabbbaaaabbaabbbbbaabbabaabbbbaabbbabaabbaaabbbbabbbabbababaababbaaaaaabaabababbbaaabbaaaaaabbbabbbbabaabaaaabbabbaabaababbaaaababaaaaababbbaabaababbbaaabaababbabbabaaabbbbaa", "*a*ab*b*ab*a*bb**bb**a**abb*bb*ab*a*bbbb***ba***aa**ba*b*ab*ba***aaabbbaa*ba*ba*b****baabb**b*aa*aaab*a"); System.out.println(b);
        b = s.isMatch("aab", "*a*ba"); System.out.println(b);
        b = s.isMatch("aab", "*"); System.out.println(b);
        b = s.isMatch("ab", "*c"); System.out.println(b);
        b = s.isMatch("a", "ab*"); System.out.println(b);
    }
}