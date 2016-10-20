package array;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.util.Map.Entry;
public class FileCount {

public Map<String,Integer> wordcou(String Filename)

//word count by sorting values and max char and words
// REPLACED non Characters

{
   Map<String,Integer>   m = new HashMap<String,Integer>();
   File f = new File(Filename);
   String maxstring = "";
   int maxwords = 0;
   
   try
   {
	   Scanner sc  = new Scanner(f);
	   while(sc.hasNextLine())
	   {
		 while(sc.hasNext())
		 {
			String tmp = sc.next().replaceAll("[^a-zA-Z]+", ""); //  Scanner in = new Scanner(new File(args[0]));in.useDelimiter("\\W+");
		  
		    if(!tmp.equals(""))
		    {
		       if(m.containsKey(tmp))
		        {
			       m.put(tmp, m.get(tmp)+ 1);
		        }
		        else
		        {
		          m.put(tmp, 1);
		        }
		   
		       if(maxwords<m.get(tmp))
		       {
			     maxwords = m.get(tmp);
			      maxstring = tmp;
		       }
		   
		     }
		   }	   
	   } 
	   System.out.println("Max String is"+ maxstring +  "maxwords is " + maxwords);
   }
   
   catch(FileNotFoundException e)
   {
	   System.out.println(e);
   }
   
 
  // converting Map to Array
   Set <Entry<String, Integer>> set = m.entrySet();
   List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);

   Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
   {
       public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
       {
           return (o2.getValue()).compareTo( o1.getValue() );
       }
   } );
   for(Map.Entry<String, Integer> entry:list){
       System.out.println(entry.getKey()+" ==== "+entry.getValue());
   }


   return m;
}




public static void main (String arg[])
{
   FileCount s = new FileCount();
   s.wordcou("C:/Users/hemanth/Desktop/test.txt");
}

}



