package leetcode.hard.DP;

import java.util.Arrays;

public class MaxSubArray {
	
	public static int maxSubArray(int[] a)
	{
		int movingfrom = 0;
		int movingend = 0;
		
		for(int val : a)
		{
			movingfrom = Math.max(0, movingfrom + val);
			movingend = Math.max(movingfrom, movingend);
		}
		
		return movingend;
	}
	
	
	 public static String findMaxSubArrayUsingFor(int[] inputArray) {
	        int maxSoFar = 0;
	        int maxEndingHere = 0;
	        int maxStartIndex = 0;
	        int maxEndIndex = 0;
	        for (int i = 0; i < inputArray.length; i++) 
	        {
	            System.out.println("ending here " + maxEndingHere);
	            System.out.println("so far " + maxSoFar);
	            if (maxEndingHere + inputArray[i] > 0) {
	                maxEndingHere = maxEndingHere + inputArray[i];
	            } else {
	                maxEndingHere = 0;
	                maxStartIndex = i + 1;
	            }
	            if (maxEndingHere > maxSoFar) {
	                maxSoFar = maxEndingHere;
	                maxEndIndex = i;
	            }
	        }
	        int[] maxArray = new int[0];
	        if (maxStartIndex <= maxEndIndex) {
	            maxArray = Arrays.copyOfRange(inputArray, maxStartIndex, maxEndIndex + 1);
	        }
	        return String.valueOf("\nInput-Array:" + Arrays.toString(inputArray)
	                + "\nMax: " + maxSoFar
	                + "\nSub-Array:" + Arrays.toString(maxArray));
	    }
	
	  public static void main(String[] args)
	   {
		
		   int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		   System.out.println( maxSubArray(a));
		   System.out.println( findMaxSubArrayUsingFor(a));
	   }

}
