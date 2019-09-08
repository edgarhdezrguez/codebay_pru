package main;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class SearchCityByLetter {
    public static void main(String letterFilter, Object obj) throws java.io.IOException {
    	try { 
        	JsonArray json = (JsonArray) obj;
        	System.out.println("****** Citys Finded *****");
        	System.out.println("-----------------------------------------");
        	for(int y=0; y < json.size(); y++) {
        		JsonObject object =(JsonObject) json.get(y);
        		String city = object.get("city").getAsString();
        		city = city.toUpperCase();
	
        		if(city.startsWith(letterFilter)) {
        			System.out.println(object);      			
        		}
        		
        	}
        	System.out.println("-----------------------------------------");
        	} catch (Exception ex) {
        		System.err.println("Error :"+ex.getMessage());	
        	}
    }
}