package main;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleComand {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

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
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        System.out.println("Escribe la letra por la que quiere filtrar: ");
                        String letterFilter = sn.next();
                        letterFilter = letterFilter.toUpperCase();
                        System.out.println("Has escrito la letra por la que filtrar: " + letterFilter);
						try {
							SearchCityByLetter.main(letterFilter);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4");
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