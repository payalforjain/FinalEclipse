package domain.dataStructures.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/sparse-arrays
public class sparseArray {
public static void main(String[] args)
{    	
	Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] input = new String[n];
    Map<String, Integer> m = new HashMap<String, Integer>();
    
    for(int i = 0 ; i < n ; i++)
    {
    	String temp = sc.next();
    	input[i] = temp;
    	
    	
    }
   
}
}
