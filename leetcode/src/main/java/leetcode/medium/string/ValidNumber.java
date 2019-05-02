package leetcode.medium.string;

public class ValidNumber {
    /*
    Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these


     */

    public boolean isNumber(String s) {
        int start = 0, end = s.length();
        while(start < end && s.charAt(start) == ' ') start++; //skip the leadingwhitspace
        if (start < end && (s.charAt(start) == '+' || s.charAt(start) == '-')) start++;//skip sign
        //test the number before . or e
        boolean isNums = false;
        while(start < end && Character.isDigit(s.charAt(start))){
            start++;
            isNums = true;
        }
        if (start < end && s.charAt(start) == '.') {//. numbers is true
            start++; //skip '.'
            while (start < end && Character.isDigit(s.charAt(start))){
                start++;
                isNums = true;
            }
        }
        if (isNums && start < end && s.charAt(start) == 'e') { //test numbers + e + (sign)numbers
            start++; // skip e
            isNums = false;
            if (start < end && (s.charAt(start) == '+' || s.charAt(start) == '-')) start++; // skip sign
            while (start < end && Character.isDigit(s.charAt(start))){
                start++;
                isNums = true;
            }

        }
        while(start < end && s.charAt(start) == ' ') start++; //skip tailing whitspaces
        return isNums && start == end;
    }
}
