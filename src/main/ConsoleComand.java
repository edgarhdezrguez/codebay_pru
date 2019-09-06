package main;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.google.gson.Gson;

public class ConsoleComand {
	/**
	 * This function just verify is the string is equal to a character not numeric
	 * @param cadena
	 * @return false if cadena is equal to number
	 * @return true if cadena is equal to letters
	 */
	
	public static boolean justLetters(String cadena)
	{
 
		for (int i = 0; i < cadena.length(); i++)
		{
			char caracter = cadena.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
				return false;
		}

		return true;
	}

	/**
	 * This is the main structure of the program, we can interactuate with the rest of files java that contein the funcionality of each of the sections required
	 * using the numbers between 1 and 4. 
	 * @param args
	 */
    public static void main(String[] args) {

        @SuppressWarnings("resource")
		Scanner sn = new Scanner(System.in);
        boolean exit = false;
        int opcion;

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
							ReadFile2.main(args);
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
                        if(justLetters(letterFilter))
                        {
							try {
								SearchCityByLetter.main(letterFilter);
							} catch (IOException e) {
								e.printStackTrace();
							}
                        }
                        else
                        {
                        	System.out.println("You have wrritted a invalid caracter.");
                        	System.out.println(" ");
                        }
                        break;
                    case 3:
                        System.out.println("You have selected the option 3");
                        System.out.println("Writte A for ascending or D for descending: ");
                        String ControlOrder = sn.next();                        
                        if(justLetters(ControlOrder)){
	                        OrderByDate2.main(ControlOrder);	                        
		                }
		                else
		                {
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
            			System.out.println("Insert value for active (true o false): ");
            			String active = sn.next();
            			
            			System.out.println("Insert email: ");
            			String email = sn.next();
            			System.out.println("Insert city: ");
            			String city = sn.next();
            			Date fecha = new Date();
            			SimpleDateFormat formatted = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
            			String creationDate = formatted.format(fecha);
            			
            			InsertNewUser User = new InsertNewUser(name,surname,active,email,city,creationDate);
            			Gson gson = new Gson();
            			String Json = gson.toJson(User);
            	      			
						try {
							AddNewUserInJson.main(Json);
						} catch (IOException e) {
							e.printStackTrace();
						}
	            			
            			System.out.println("result: " + Json);
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