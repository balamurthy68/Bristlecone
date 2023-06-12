package DataDriven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
  
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

  public class jsonReader {
   public static void main(String[] args) throws IOException, ParseException {
       try(FileReader reader = new FileReader("d://users.json")) {
	   JSONParser jsonParser = new JSONParser();
       JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

       
    // get an array from the JSON object
       JSONArray emp = (JSONArray) jsonObject.get("employees");
       
       Iterator i = emp.iterator();

       // take each value from the json array separately
       while (i.hasNext()) {
           JSONObject innerObj = (JSONObject) i.next();
           System.out.println("Username:" +  innerObj.get("username") +
                   " Password:" + innerObj.get("password"));
       }

       }
   }
  }
  