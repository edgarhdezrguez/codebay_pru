package main;
import java.io.FileReader;
import java.util.Collections;
import java.util.Date;

import javax.xml.crypto.Data;

import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class OrderByDate {
	private static final String datas = "data.json";
    public static void main(String args[]) throws java.io.IOException {
    	try {    
          	JsonParser parser = new JsonParser();
        	FileReader fr = new FileReader("data.json");
        	Object obj = parser.parse(new FileReader(datas));
        	JsonArray json = (JsonArray) obj;
        	System.out.println("****** Longitud de la cadena *****: " + json.size());
        	System.out.println("-----------------------------------------");
        	JsonObject object2 =(JsonObject) json.getAsJsonObject();
        	//String city = object2.get("city").getAsString();
    		JsonElement date2 = object2.get("creationDate");
    		System.out.println("****** creationDate antes del for *****: " + date2);
        	for(int y=0; y < json.size(); y++) {
        		JsonObject object =(JsonObject) json.get(y);
        		//boolean active = object.get("active").getAsBoolean();
        		String city = object.get("city").getAsString();
        		JsonElement date = object.get("creationDate");
        		System.out.println("****** creationDate *****: " + date);
        		city = city.toUpperCase();
        		//System.out.println("+++++ Antes de If active, objecto ++++: " + object);
        		
        		//System.out.println("+++++ Antes de If active, valor de active ++++: " + active);
        		
        		/*if(city.startsWith()) {
        			System.out.println("+++++ Usuario Activo ++++: " + object);
        			System.out.println("-----------------------------------------");
        			/*JsonPrimitive valor = elemento.getAsJsonPrimitive();
        			if(valor.isBoolean()){
        				
        				System.out.println("****** DATOS SEGUNDA FUNC *****: " + array.getAsJsonArray());
        				
        			}
        			
        		}*/
        		
        	}
        	System.out.println("-----------------------------------------");
        	} catch (Exception ex) {
        		System.err.println("Error :"+ex.getMessage());	
        	}
    }
    
    public static class MyObject implements Comparable<MyObject> { 

        private Date dateTime; 

        public Date getDateTime() { 
        return dateTime; 
        } 

        public void setDateTime(Date datetime) { 
        this.dateTime = datetime; 
        } 

        @Override 
        public int compareTo(MyObject o) { 
        return getDateTime().compareTo(o.getDateTime()); 
        } 
        
       
    } 
}