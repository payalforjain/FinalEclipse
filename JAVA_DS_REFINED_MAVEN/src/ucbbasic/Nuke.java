/* Write a program called "Nuke2.java" containing a class called Nuke2 whose main
method reads a string from the keyboard and prints the same string, with its
second character removed. (That’s character number 1, since Java numbers
characters in a string starting from zero.) In other words, after you run
"java Nuke2", if you type in the string "skin", the program will print "sin".*/

package ucbbasic;


import java.net.*;
import java.io.*;
import java.util.*;

class Nuke
{
   public static void main(String[] args) throws Exception
   {
       String inputLine;
	   BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	   System.out.print("Please enter the name of a company (without spaces): ");
       System.out.flush();        /* Make sure the line is printed immediately. */
       inputLine = keyboard.readLine();
	   String newstring = inputLine.substring(0,1) + inputLine.substring(2);
	   System.out.println("new String is:" + newstring);
   }


  

}