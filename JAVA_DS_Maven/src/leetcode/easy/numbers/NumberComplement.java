package leetcode.easy.numbers;

public class NumberComplement {
	
	 public static int findComplement(int num) {
		 
		 int bin = num << 8;
		 return bin;
	        
	    }
	 
	 
	 public static void main(String[] args)
	 {
		 System.out.println(findComplement(2));
	 }

}
