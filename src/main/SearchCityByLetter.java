package main;
import java.io.FileReader;

import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class SearchCityByLetter {
	private static final String datas = "data.json";
    public static void main(String letterFilter) throws java.io.IOException {
    	try {    
          	JsonParser parser = new JsonParser();
        	
        	Object obj = parser.parse(new FileReader(datas));
        	JsonArray json = (JsonArray) obj;
        	System.out.println("****** Ciudades Encontradas *****");
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