package main;

public class InsertNewUser {

	private String name;
	private String surname;
	private Boolean active;
	private String email;
	private String city;
	private String creationDate;
	
	public InsertNewUser(String name1, String surname1, Boolean active1, String email1, String city1, String creationDate1)
	{
		this.name = name1;
		this.surname = surname1;
		this.active = active1;
		this.city = city1;
		this.email = email1;
		this.creationDate = creationDate1;
		
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
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
 
}