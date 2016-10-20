package ucbbasic;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class second {
     void run()
	 {
        try {

	          String csvFile = "C:/roster.txt";
	          BufferedReader br = new BufferedReader(new FileReader(csvFile));
	          String line = "";
	          String cvsSplitBy = ",";
              ArrayList<String> rows = new ArrayList<String>();
              
			  while ((line = br.readLine()) != null) 
			  {
                 String[] country = line.split(cvsSplitBy);
                 rows.add(country[1].trim());

              }
          Collections.sort(rows);
	      System.out.println(rows);
		
	}
	
	
	catch(IOException ex) {

            System.err.println("An IOException was caught!");

            ex.printStackTrace();

        }
	
	 }
  public static void main(String[] args) throws Exception
  {
     second d = new second();
	 d.run();
  } 

	
 
}
 
	
