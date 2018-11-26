package leetcode.easy.stringManipulation;

public class ToLowerCase {

/*
Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
 */
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c:str.toCharArray()){
            if(c>=65 && c <=90){
                c=(char)(c+32);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
