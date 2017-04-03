package facebook;

public class GCD {
	
	  public static int gcd(int p, int q) {
          if (q == 0) {
                  return p;
          }
          return gcd(q, p % q);
  }
	  
	  public static int gcdIteration(int x, int y) {
		  int r=0, a, b;
	        a = (x > y) ? x : y; // a is greater number
	        b = (x < y) ? x : y; // b is smaller number
	 
	        r = b;
	        while(a % b != 0)
	        {
	            r = a % b;
	            a = b;
	            b = r;
	        }
	        return r;
         
	  }    
	  public static void main(String[] args) {
          System.out.println (gcd(4, 16) == 4);
          System.out.println (gcd(16, 4) == 4);
          System.out.println (gcd(15, 60) == 15);
          System.out.println (gcd(15, 65) == 5);
          System.out.println (gcd(1052, 52) == 4);
          
          System.out.println (gcdIteration(4, 16) == 4);
          System.out.println (gcdIteration(16, 4) == 4);
          System.out.println (gcdIteration(15, 60) == 15);
          System.out.println (gcdIteration(15, 65) == 5);
          System.out.println (gcdIteration(1052, 52) == 4);
  }

}
