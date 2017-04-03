package leetcode.easy.numbers;

public class NumberToHexaDecimal {
	//http://massivealgorithms.blogspot.com/2016/09/leetcode-405-convert-number-to.html
	
	public static String toHex(int num) {
		  if (num==0) {
		            return "0";
		        }
		        int minVal = Integer.MIN_VALUE;
		        int maxVal = Integer.MAX_VALUE;
		        long test=num>=0?num:1l+num-minVal+maxVal;
		        String ans="";
		        while (test!=0) {
		            int t=(int) (test%16);
		            if (t<10) {
		                ans=String.valueOf(t)+ans;
		            }else{
		                ans=String.valueOf((char)('a'+t-10))+ans;
		            }
		            test/=16;
		        }
		        return ans;
		    }

	

public static void main(String[] args)
{
  System.out.println(toHex(-1));	
}
}