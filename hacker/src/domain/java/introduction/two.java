package domain.java.introduction;

import java.util.Scanner;

/*
 * One way to take input from stdin is to use the Scanner class and read in from System.in.

You can write your output to stdout by simply using the System.out.println(String) function.

In this problem, you need to read 3 integers from stdin and print them in stdout.
 */
public class two {
	
	

	    public static void main(String[] args) {
	      Scanner sc=new Scanner(System.in);
	      for(int i=0;i<3;i++){
				int a=sc.nextInt();
				System.out.println(a);
			}
	    
	    }
	
}
