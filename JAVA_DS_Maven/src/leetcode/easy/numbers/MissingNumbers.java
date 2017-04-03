package leetcode.easy.numbers;

public class MissingNumbers {
	
	
	public static int getMissingNumbers(int[] nums)
	{
		int output = 0;
	    int n = nums.length;
	    for (int i = 0 ; i < nums.length; i++)
	    {
	    	output = output + nums[i];
	    }
		
	    int sum  = (n * (n+1) )  /2 ;
	    
		return sum - output;
	}
	
	public static void main(String[] args)
	{
		int[] nums = {0,1,3};
		System.out.println(getMissingNumbers(nums));
	}

}
