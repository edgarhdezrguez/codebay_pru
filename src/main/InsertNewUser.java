package main;
import java.text.SimpleDateFormat;

public class InsertNewUser {

	private String name;
	private String surname;
	private String active;
	private String email;
	private String city;
	private String creationDate;
	
	public InsertNewUser(String name1, String surname1, String active1, String email1, String city1, String creationDate1)
	{
		this.name = name1;
		this.surname = surname1;
		this.active = active1;
		this.city = city1;
		this.email = email1;
		this.creationDate = creationDate1;
		/*NewUser1.add(name);
		NewUser1.add(surname);
		NewUser1.add(active);
		NewUser1.add(email);
		NewUser1.add(city);
		NewUser1.add(creationDate);*/
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	/*
    public static void main(String args[ ]) throws java.io.IOException {
    	String name;
    	String surname;
    	String active;
    	String email;
    	String city;
    	Scanner sn = new Scanner(System.in);
    	Collection NewUser = new ArrayList();
    	System.out.println("Inserte el nombre: ");
		name = sn.next();
		System.out.println("Inserte el apellido: ");
		surname = sn.next();
		System.out.println("Inserte si es activo (true o false): ");
		active = sn.next();
		System.out.println("Inserte el email: ");
		email = sn.next();
		System.out.println("Inserte la ciudad: ");
		city = sn.next();
		
		SimpleDateFormat creationDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
		
		NewUser.add(name);
		NewUser.add(surname);
		NewUser.add(active);
		NewUser.add(active);
		NewUser.add(email);
		NewUser.add(city);
		NewUser.add(creationDate);
		
		//JsonObject object =(JsonObject) NewUser;
		
		System.out.println("resultado: " + NewUser);
    	//ArrayList<JsonObject> NewUser2 = new ArrayList<>();
    	//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
    	   /*
    		static class InsertNewUserMain{
    			System.out.println("Inserte el nombre: ");
    			String name = sn.next();
    			System.out.println("Inserte el apellido: ");
    			String surname = sn.next();
    			System.out.println("Inserte si es activo (true o false): ");
    			String active = sn.next();
    			System.out.println("Inserte el email: ");
    			String email = sn.next();
    			System.out.println("Inserte la ciudad: ");
    			String city = sn.next();
    			SimpleDateFormat creationDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
    		private InsertNewUser (String name, String surname, String active, String email, String city, SimpleDateFormat creationDate)
    		{
    			
    		}
    			
    		
    }*/
 
}