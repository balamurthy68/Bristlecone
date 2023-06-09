package DataDriven;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.*;

public class csvReader {
	
	static String s_id,s_username,s_password= "";
	
	public static void main(String[] args) throws Exception {
		// This will load csv file 
				CSVReader reader = new CSVReader(new FileReader("d:\\usersdatacsv.csv"));

				// this will load content into list
				List<String[]> li=reader.readAll();
				 System.out.println("Total rows which we have is "+li.size());
				// create Iterator reference
				Iterator<String[]>i1= li.iterator();
				// Iterate all values 
				while(i1.hasNext()){
				//each row
					String[] str=i1.next();
					String s_un = null;
				String s_pw = null;
				//System.out.print(" Values are ");
				//for each column seperated by commas	
				
				for(int i=0;i<str.length-1;i++)
				{
				
					String [] myArray = str[i].split(",");
				s_un = myArray[0];
				s_pw = myArray[1];
					/*
					 //if i = 0 then it is username 
					 //if i = 1 then it is password
					 
					  
				      switch (i) {
				      case 0:
				    	     s_un = str[i];
				    	     break;
				      case 1:
				    	  	 s_pw = str[i];
				    	  	 break;
				      
				      }
				  */
				
				      
				      
				}
				 
				 // here you can call a webdriver method to supply values as parameters from 
				//each row of the csv file
				
	    System.out.println( " name:"+ s_un + " Password:" + s_pw);
				    
				    System.out.println("   ");
				}

	
			}

}
