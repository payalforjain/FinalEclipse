package domain.java.introduction;

import java.util.Scanner;

/*
 * 
 * Input Format

Every line of input will contain a String followed by an integer. 
Each String will have a maximum of  alphabetic characters, and each integer will be in the inclusive range from  to .

Output Format

In each line of output there should be two columns: 
The first column contains the String and is left justified using exactly  characters. 
The second column contains the integer, expressed in exactly  digits; if the original input has less than three digits, you must pad your output's leading digits with zeroes.

Sample Input

java 100
cpp 65
python 50
Sample Output

================================
java           100 
cpp            065 
python         050 
 */
public class Four {
	 public static void main(String[] args) {
	
	 Scanner sc=new Scanner(System.in);
     
     String[] output = new String[3];
     for(int i=0;i<3;i++)
     {
         String s1=sc.next();
         int x=sc.nextInt();
         //Complete this line
         int remainingSpacesForString = 15- s1.length();
         String temp = ""+ x;
         int remainingZeroForInt  = 3- temp.length();
         
         String outputString= s1 + String.format("%" + remainingSpacesForString + "s", "" );
         String outputInt = "";
         if(remainingZeroForInt>0)
         {
        	String tempString =  String.format("%" + remainingZeroForInt + "s", "" ) ;
        	outputInt = tempString.replace(" ", "0")+ x;
        	
         }
         else
         {
        	 outputInt = x +"";
         }
         output[i] = outputString+ outputInt;
        
     }
     System.out.println("================================");
     System.out.println(output[0]);
     System.out.println(output[1]);
     System.out.println(output[2]);
     System.out.println("================================");
	 }

}
