package leetcode.easy.stringManipulation;

import java.util.Stack;

public class ReverseString {

    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] cs = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            swap(cs, start, end);
            start++;
            end--;
        }

        return new String(cs);
    }

    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
    //time exceeded
    public String reverseString2(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    public static void reverseStringUsingStack(String inputString) {
        if (inputString.isEmpty()) {
            System.out.println("Please enter a valid string.");
        } else if (inputString.length() == 1) {
            System.out.println(inputString);
        } else {
            Stack<Character> stack = new Stack<Character>();
            String reverseString = "";
            int counter = 0;
            while (counter < inputString.length()) {
                stack.push(inputString.charAt(counter));
                counter++;
            }
            while (!stack.isEmpty()) {
                reverseString = reverseString + stack.pop();
            }
            System.out.println("Original String: " + inputString);
            System.out.println("Reversed String: " + reverseString);
        }
    }
}
