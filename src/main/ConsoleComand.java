package main;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.google.gson.Gson;

public class ConsoleComand {
	
	public static boolean esSoloLetras(String cadena)
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

    public static void main(String[] args) {

        @SuppressWarnings("resource")
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("1. Listar usuarios activos");
            System.out.println("2. Listar las ciudades cuya ciudad empiece por lo que inserte.");
            System.out.println("3. Listar los usuarios por fecha de creación (Ascendente y Descendente)");
            System.out.println("4. Añadir un usuario");
            System.out.println("5. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");                     
						try {
							ReadFile2.main(args);
						} catch (IOException e) {
							e.printStackTrace();
						}
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        System.out.println("Escribe la letra por la que quiere filtrar: ");
                        String letterFilter = sn.next();
                        letterFilter = letterFilter.toUpperCase();
                        System.out.println("Has escrito la letra por la que filtrar: " + letterFilter);
                        if(esSoloLetras(letterFilter))
                        {
							try {
								SearchCityByLetter.main(letterFilter);
							} catch (IOException e) {
								e.printStackTrace();
							}
                        }
                        else
                        {
                        	System.out.println("Se ha escrito un caracter incorrecto.");
                        	System.out.println(" ");
                        }
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        System.out.println("Escribe A para ascendente o D para descendente: ");
                        String ControlOrder = sn.next();                        
                        if(esSoloLetras(ControlOrder)){
	                        OrderByDate2.main(ControlOrder);	                        
		                }
		                else
		                {
		                	System.out.println("Se ha escrito un caracter incorrecto.");
		                	System.out.println(" ");
		                }    
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4");
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
            			Date fecha = new Date();
            			SimpleDateFormat formatted = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
            			String creationDate = formatted.format(fecha);
            			
            			InsertNewUser User = new InsertNewUser(name,surname,active,email,city,creationDate);
            			System.out.println("despues de insert User: " + User);
            			Gson gson = new Gson();
            			String Json = gson.toJson(User);            			
						try {
							AddNewUserInJson.main(Json);
						} catch (IOException e) {
							e.printStackTrace();
						}
	            			
            			System.out.println("resultado: " + Json);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }
}