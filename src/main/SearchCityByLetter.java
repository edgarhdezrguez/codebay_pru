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
        	System.out.println("****** Longitud de la cadena *****: " + json.size());
        	System.out.println("-----------------------------------------");
        	for(int y=0; y < json.size(); y++) {
        		JsonObject object =(JsonObject) json.get(y);
        		//boolean active = object.get("active").getAsBoolean();
        		String city = object.get("city").getAsString();
        		city = city.toUpperCase();
        		//System.out.println("+++++ Antes de If active, objecto ++++: " + object);
        		
        		//System.out.println("+++++ Antes de If active, valor de active ++++: " + active);
        		
        		if(city.startsWith(letterFilter)) {
        			System.out.println("+++++ Usuario Activo ++++: " + object);
        			System.out.println("-----------------------------------------");        			
        		}
        		
        	}
        	System.out.println("-----------------------------------------");
        	} catch (Exception ex) {
        		System.err.println("Error :"+ex.getMessage());	
        	}
    }
}