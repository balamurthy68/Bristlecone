package general;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class log4jTester {
	/* Get actual class name to be printed on */
	   
	static Logger log = Logger.getLogger(log4jTester.class);
	public static void main(String[] args)
	
	{
	    
		//BasicConfigurator.configure();
        
		String log4jConfigFile = System.getProperty("user.dir")
				+ File.separator + "log4j.properties";
		
		System.out.println(log4jConfigFile);
		PropertyConfigurator.configure(log4jConfigFile);
						
		log.info("This is my first info log4j's statement");
	    log.debug("Hello this is a debug message" + "abcd "+"efgh");
		log.error("Error!");
	    
	    System.out.println("Testing");
	   }
}