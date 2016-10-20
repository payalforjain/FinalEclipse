package array;



public class Homework3 {



  public static void smoosh(int[] ints) {
   
	  for(int i=0; i <ints.length-1;i++)
	  {
		  while(ints[i] == ints[i+1] && ints[i] != -1)
		  {
			  for(int t=i;t<ints.length-1; t++)
			  {
				  ints[t]=ints[t+1];
				  
			  }
			  ints[ints.length-1] = -1;
			  
		  }
	  }
	 
  }
  
  private static String stringInts(int[] ints) {
	    String s = "[  ";
	    for (int i = 0; i < ints.length; i++) {
	      s = s + Integer.toString(ints[i]) + "  ";
	    }
	    return s + "]";
	  }


  public static void main(String[] args) {
    String result;
    //int i;


    System.out.println("Let's smoosh arrays!\n");

    int[] test1 = {3, 7, 7, 7, 4, 5, 5, 2, 0, 8, 8, 8, 8, 5};
    System.out.println("smooshing " + stringInts(test1) + ":");
    smoosh(test1);
    result = stringInts(test1);
    System.out.println(result);
    
    int[] test2 = {6, 6, 6, 6, 6, 3, 6, 3, 6, 3, 3, 3, 3, 3, 3};
    System.out.println("smooshing " + stringInts(test2) + ":");
    smoosh(test2);
    result = stringInts(test2);
    System.out.println(result);
    
    int[] test3 = {4, 4, 4, 4, 4};
    System.out.println("smooshing " + stringInts(test3) + ":");
    smoosh(test3);
    result = stringInts(test3);
    System.out.println(result);
  

    int[] test4 = {0, 1, 2, 3, 4, 5, 6};
    System.out.println("smooshing " + stringInts(test4) + ":");
    smoosh(test4);
    result = stringInts(test4);
    System.out.println(result);
   
  }

}