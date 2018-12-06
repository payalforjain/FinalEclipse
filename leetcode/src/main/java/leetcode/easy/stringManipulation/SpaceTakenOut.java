package leetcode.easy.stringManipulation;

import java.util.Set;
import java.util.Stack;

public class SpaceTakenOut {
// Given a string of words with the spaces taken out and a dictionary of all possible words, put the spaces back in.
//
// e.g. "acat" => "a cat
//
// Amazon Question"

    public static String spaceTakenOut(String input , Set<String> words)
    {

        StringBuilder result =  new StringBuilder();

        if( input.length() ==0 || input ==null )
        {
            return "";
        }

        if(words.contains(input) )
        {
            return input;
        }


    else
        {
            StringBuilder temp =  new StringBuilder();

            for(int i =0 ; i< input.length() ; i++)
            {
                temp = temp.append( input.charAt(i));

                if(words.contains(temp.toString()))
                {
                    result = result.append(temp).append(" ");
                    temp = new StringBuilder();
                }
            }
        }

        return result.toString();

    }


    public static class EvaluateReversePolishNotation {

        /*
        Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, /. Each operand may be an integer or another expression.

    Note:

    Division between two integers should truncate toward zero.
    The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
    Example 1:

    Input: ["2", "1", "+", "3", "*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9
    Example 2:

    Input: ["4", "13", "5", "/", "+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6
    Example 3:

    Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    Output: 22
    Explanation:
      ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    = ((10 * (6 / (12 * -11))) + 17) + 5
    = ((10 * (6 / -132)) + 17) + 5
    = ((10 * 0) + 17) + 5
    = (0 + 17) + 5
    = 17 + 5
    = 22
         */
        public int evalRPN(String[] tokens) {


            String operator = "+-*/";
            Stack<String> stack = new Stack();

            for(String token : tokens)
            {
                if(!operator.contains(token))
                {
                    stack.push(token);
                }

                else
                {
                    int index = operator.indexOf(token);
                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
                    switch(index){
                        case 0 :
                            stack.push(String.valueOf(a+b));
                            break;
                        case 1 :
                            stack.push(String.valueOf(b-a));
                            break;
                        case 2 :
                            stack.push(String.valueOf(a*b));
                            break;
                        case 3 :
                            stack.push(String.valueOf(b/a));
                            break;
                    }
                }
            }

            return Integer.valueOf(stack.pop());

        }
    }
}
