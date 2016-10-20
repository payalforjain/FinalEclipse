package domain.java.String;

import java.util.Scanner;

/*
 * Input Format

First line will consist a string containing english alphabets which has at most  characters. 2nd line will consist an integer .

Output Format

In the first line print the lexicographically minimum substring. In the second line print the lexicographically maximum substring.

Sample Input

welcometojava
3
Sample Output

ava
wel
Explanation

Here is the list of all substrings of length :

wel
elc
lco
com
ome
met
eto
toj
oja
jav
ava
 */
public class Second {

	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String input = sc.next();
       int number = sc.nextInt();
       String min= input.substring(0,number);
       String max = input.substring(0,number);
       int noOfItereation = input.length() - number;
       
       for(int i =1 ; i<= noOfItereation ; i++)
       {
    	   String temp = input.substring(i,++number);
    	   max = max.compareTo(temp) >0 ? max : temp;
    	   min = min.compareTo(temp) <0 ? min : temp;
       }
       System.out.println(min);
       System.out.println(max);
    }
	
}