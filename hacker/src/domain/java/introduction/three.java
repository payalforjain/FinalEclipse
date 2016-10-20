package domain.java.introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 
 * Input Format

There are three lines of input. 
Line one contains an integer. 
Line two contains a double. 
Line three contains a String.

Output Format

On the first line, print String: followed by the unaltered input String. 
On the second line, print Double: followed by the unaltered input double. 
On the third line, print Int: followed by the unaltered input integer.

To make the problem easier, a portion of the code is already provided in the editor.

Note: If you use the nextLine() method immediately following the nextInt() method, recall that nextInt() reads integer tokens; because of this, the last newline character for that line of integer input is still queued in the input buffer and the next nextLine() will be reading the remainder of the integer line (which is empty).

Sample Input

42
3.1415
Welcome to HackerRank Java tutorials!
Sample Output

String: Welcome to HackerRank Java tutorials!
Double: 3.1415
Int: 42
 */
public class three {
	  public static void main(String[] args) {
		  Scanner scan = new Scanner(System.in);
	       
	        int i = Integer.parseInt(scan.nextLine().toString());
	        
		      double d = Double.parseDouble(scan.nextLine().toString());
		      String s = scan.nextLine();
	        // Write your code here.

	        System.out.println("String: " + s);
	        System.out.println("Double: " + d);
	        System.out.println("Int: " + i);
	    
	    }

}
