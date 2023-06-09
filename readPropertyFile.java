package general;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream("homepage.properties");
		obj.load(objfile);             
		String s_title = obj.getProperty("title");
        String s_bkcolor = obj.getProperty("bkcolor");
		
        System.out.println(s_title);
        
        
        System.out.println(s_bkcolor);
        
	}

}
