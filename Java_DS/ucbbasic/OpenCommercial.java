package ucbbasic;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

import java.io.*;
import java.net.URL;

public class OpenCommercial {
	


		  public static void main(String[] arg) throws Exception {

		    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		    String inputLine;

		    
		    System.out.print("Please enter the name of a company (without spaces): ");
		    System.out.flush();        /* Make sure the line is printed immediately. */
		    inputLine = keyboard.readLine();

		   ArrayList v = new ArrayList();
		    
		    
		    String web = "http://www."+ inputLine +".com/";
		    System.out.println(web);
		    URL a = new URL(web);
		    try
		    {
		    	
		    
		    InputStream i = a.openStream();
		    InputStreamReader d = new InputStreamReader(i);
		    BufferedReader k = new BufferedReader(d);
		    int x =0;
		   while(x<5)
		   {
			   String s = k.readLine();
			   v.add(s);
			   
			   
			  
			   x++;
			   
		   }
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		   
		   for( int f = v.size()-1; f>=0;f--)
		   {
			   System.out.println(v.get(f));
		   }
		    
		  }
		  
}