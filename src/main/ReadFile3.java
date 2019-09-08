package main;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class ReadFile3 {
	//private static final String datas = "data.json";
    public static void main(Object obj) throws java.io.IOException {
    	try {        	
        	//JsonParser parser = new JsonParser();
        	//Object obj = parser.parse(new FileReader(datas));
        	JsonArray json = (JsonArray) obj;
        	System.out.println("****** Not Active Users ***** ");
        	System.out.println("-----------------------------------------");
        	for(int y=0; y < json.size(); y++) {
        		JsonObject object =(JsonObject) json.get(y);
        		boolean active = object.get("active").getAsBoolean();        		
        		if(!active) {
        			System.out.println(object);        			
        		}        		
        	}
        	System.out.println("-----------------------------------------");
        	} catch (Exception ex) {
        		System.err.println("Error :"+ex.getMessage());	
        	}
    }
 
}