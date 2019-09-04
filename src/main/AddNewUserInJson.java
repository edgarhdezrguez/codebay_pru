package main;
import java.io.FileReader;

import com.google.gson.JsonParser;
import com.google.gson.JsonArray;

public class AddNewUserInJson {
	private static final String datas = "data.json";
    public static void main(String json2) throws java.io.IOException {
    	try {        	
        	JsonParser parser = new JsonParser();
        	Object obj = parser.parse(new FileReader(datas));
        	JsonArray json = (JsonArray) obj;
        	System.out.println("User to add: " + json2);
        	
        	System.out.println("-----------------------------------------");
        	json2.toString();
        	System.out.println("json2 to string: " + json2.toString());
        	
        	json.add(json2);

        	System.out.println("-----------------------------------------");
        	} catch (Exception ex) {
        		System.err.println("Error :"+ex.getMessage());	
        	}
    }
 
}