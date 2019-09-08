package main;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ConsoleComand {
	
	/**
	 * This function just verify is the string is equal to a character not numeric
	 * 
	 * @param cadena
	 * @return false if cadena is equal to number
	 * @return true if cadena is equal to letters
	 */
	public static boolean justLetters(String cadena) {

		for (int i = 0; i < cadena.length(); i++) {
			char caracter = cadena.toUpperCase().charAt(i);
			int valorASCII = (int) caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
				return false;
		}

		return true;
	}

	public static Boolean validationNewUser(String name, String surname, String email, String city) {
		Boolean validation = true;
		String caracteristic;
		String nameCaract;
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				caracteristic = name;
				nameCaract = "name";
			} else if (i == 1) {
				caracteristic = surname;
				nameCaract = "surname";
			} else {
				caracteristic = city;
				nameCaract = "city";
			}

			for (int y = 0; y < caracteristic.length(); y++) {
				char caracter = caracteristic.toUpperCase().charAt(y);
				int valorASCII = (int) caracter;
				if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)) {
					validation = false;
				}
			}
			if (!validation)
				System.out.println("You have writted an invalid caracter in field " + nameCaract);
		}

		Pattern pat = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
		Matcher mather = pat.matcher(email);

		if (mather.find() == false) {
			validation = false;
			System.out.println("You have writted an invalid caracter in field email.");
		}
		if (validation) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This is the main structure of the program, we can interactuate with the rest
	 * of files java that contein the funcionality of each of the sections required
	 * using the numbers between 1 and 4.
	 * 
	 * @param args
	 * @throws JsonSyntaxException 
	 * @throws JsonIOException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException {

		@SuppressWarnings("resource")
		Scanner sn = new Scanner(System.in);
		boolean exit = false;
		int opcion;
		String datas = "data.json";
		JsonParser parser = new JsonParser();
		Object obj = parser.parse(new FileReader(datas));
		
		while (!exit) {
			System.out.println("1. List active users");
			System.out.println("2. List the cities with first letter is the inserted.");
			System.out.println("3. List the users for date of creation (Ascending or Descending)");
			System.out.println("4. Add a user");
			System.out.println("5. Exit");
			try {
				System.out.println("Writte one of the options");
				opcion = sn.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("You have selected the option 1");
					try {
						ReadFile2.main(obj);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("You have selected the option 2");
					System.out.println("Writte the letter what you want for filter: ");
					String letterFilter = sn.next();
					letterFilter = letterFilter.toUpperCase();
					System.out.println("Yo have writte the next letter for filtered: " + letterFilter);
					if (justLetters(letterFilter)) {
						try {
							SearchCityByLetter.main(letterFilter, obj);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("You have wrritted a invalid caracter.");
						System.out.println(" ");
					}
					break;
				case 3:
					System.out.println("You have selected the option 3");
					System.out.println("Writte A for ascending or D for descending: ");
					String ControlOrder = sn.next();
					if (justLetters(ControlOrder)) {
						OrderByDate2.main(ControlOrder, obj);
					} else {
						System.out.println("You have wrritted a invalid caracter.");
						System.out.println(" ");
					}
					break;
				case 4:
					
					System.out.println("You have selected the option 4");
					System.out.println("Insert name: ");
					String name = sn.next();
					System.out.println("Insert surname: ");
					String surname = sn.next();
					System.out.println("Insert value for active (yes or not): ");
					String active1 = sn.next();
					Boolean active = false;
					Boolean validateActive = true;
					System.out.println("Insert email: ");
					String email = sn.next();
					System.out.println("Insert city: ");
					String city = sn.next();

					Date fecha = new Date();
					SimpleDateFormat formatted = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
					String creationDate = formatted.format(fecha);
					boolean varValNewUser = validationNewUser(name, surname, email, city).booleanValue();

					active1 = active1.toUpperCase().substring(0, 1);
					if (active1.equals("Y")) {
						active = true;
					} else if (active1.equals("N")) {
						active = false;
					} else {
						System.out.println("You have writted an invalid caracter in field active.");
						validateActive = false;
					}

					if (varValNewUser && validateActive) {
						InsertNewUser User = new InsertNewUser(name, surname, active, email, city, creationDate);
						Gson gson = new Gson();
						String Json = gson.toJson(User);
						
						AddNewUserInJson.main(Json, obj);
						
					} else {
						break;
					}
					System.out.println(" ");
					System.out.println("***** List of Users in BBDD: *****");
					System.out.println("-----------------------------------------------");
					ReadFile2.main(obj);
					ReadFile3.main(obj);
					System.out.println("-----------------------------------------------");
					break;
				case 5:
					exit = true;
					break;
				default:
					System.out.println("Only numbers between 1 and 5");
				}
			} catch (InputMismatchException e) {
				System.out.println("You should insert a number");
				sn.next();
			}
		}

	}
}