package main;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AddNewUserInJson {
	
    public static void main(String json2, Object obj) throws java.io.IOException {
    	try {        	
        	JsonArray json = (JsonArray) obj;
        	JsonObject obj2 = new JsonParser().parse(json2).getAsJsonObject();
        	System.out.println("User to add: " + obj2);
        	System.out.println("-----------------------------------------");

        	json.add(obj2);
        	
        	} catch (Exception ex) {
        		System.err.println("Error :"+ex.getMessage());	
        	}
    }
 
}