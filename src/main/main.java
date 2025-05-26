package main;

import controlador.LibroControlador;
import controlador.LectorControlador;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // Mostramos el menú principal
            System.out.println("Gestion de una Biblioteca");
            System.out.println("1. Para poder gestionar libros");
            System.out.println("2. Para poder gestionar lectores");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = Integer.parseInt(sc.nextLine());

            // Elegimos la opción de lo que queremos hacer:
            switch (opcion) {
                case 1:
                    LibroControlador.menu();
                    break;
                case 2:
                    LectorControlador.menu();
                    break;
                case 3:
                    System.out.println("Saliendo de la biblioteca, adios");
                    break;
                default:
                    System.out.println("Esa opcion no está disponible.");
            }
        } while (opcion != 3);
    }
}
