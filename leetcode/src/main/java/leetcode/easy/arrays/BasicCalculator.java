package leetcode.easy.arrays;
import  java.util.*;
public class BasicCalculator {

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
 */
        public int calculate(String s) {

            char operator ='+';
            int result=0;
            int number=0;
            Stack<Integer> stack = new Stack<>();

            for(int i =0 ; i<s.length(); i++)
            {
                char temp = s.charAt(i);
                if(Character.isDigit(temp))
                {
                    number = number *  10 + (temp - '0');
                }

                if(i==s.length()-1 ||  (!Character.isDigit(temp)  && temp != ' ' ))
                {
                    if(operator == '+')
                    {
                        stack.push(number);
                    }

                    else if(operator == '-')
                    {
                        stack.push(-number);
                    }

                    else if(operator == '*')
                    {
                        stack.push( stack.pop() * number);
                    }
                    else if(operator == '/')
                    {
                        stack.push( stack.pop() / number);
                    }
                    number = 0;
                    operator = temp;
                }



            }
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
            return result;

        }

        /*
        Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
         */
    public int calculate2(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;
    }



    public static void main(String[] args)
        {
            BasicCalculator s = new BasicCalculator();
            s.calculate2( "(-12+(4-5+2)-3)+(6+8)");
        }
}
