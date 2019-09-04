package main;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class OrderByDate2 {

public static void main(String args) {
    JsonParser parser = new JsonParser();
    String Orden = args;

    final String datas = "data.json";
    try {
    	
    	Object o = parser.parse(new FileReader(datas));
    	JsonArray ob = (JsonArray) o;
        JsonArray array = ob;
        ArrayList<JsonObject> list = new ArrayList<>();

        
        for (int i = 0; i < array.size(); i++) {
            list.add((JsonObject) array.get(i));
        }
        
        Orden = Orden.toUpperCase().substring(0, 1);
        
        if(Orden.equals("A")) {
        	System.out.println("*********** Usuarios ordenados Ascendentemente **********");
        	Collections.sort(list, new MyJSONComparatorAsc());
        	
        }else{
        	System.out.println("*********** Usuarios ordenados Descendentemente **********");
        	Collections.sort(list, new MyJSONComparatorDes());
        }
        
        for (JsonObject obj : list) {
            System.out.println(obj);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}

class MyJSONComparatorDes implements Comparator<JsonObject> {
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
@Override
public int compare(JsonObject o1, JsonObject o2) {
    String v1 = o1.get("creationDate").getAsString();
    String v3 = o2.get("creationDate").getAsString();
    try {
    	return formatter.parse(v3).compareTo(formatter.parse(v1));
	} catch (ParseException e) {
		throw new IllegalArgumentException(e); 
	}
	
}

}

class MyJSONComparatorAsc implements Comparator<JsonObject> {
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
@Override
public int compare(JsonObject o1, JsonObject o2) {
    String v1 = o1.get("creationDate").getAsString();
    String v3 = o2.get("creationDate").getAsString();
    try {
		return formatter.parse(v1).compareTo(formatter.parse(v3));
	} catch (ParseException e) {
		throw new IllegalArgumentException(e); 
	}
	
}

}