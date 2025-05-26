package controlador;

import modelo.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

// Clase para gestionar la lógica relacionada a los lectores desde consola.
public class LectorControlador {

    private static LectorDAO dao = new LectorDAO();
    private static Scanner sc = new Scanner(System.in);

    // Menú principal para lectores
    public static void menu() {
        int opcion;
        do {
            System.out.println("Bienvenido a la gestion de lectores");
            System.out.println("1. Agregar un nuevo lector:");
            System.out.println("2. Lista todos los lectores:");
            System.out.println("3. Editar un lector:");
            System.out.println("4. Eliminar un lector:");
            System.out.println("5. Volver al Menu Principal:");
            System.out.print("¿Que quieres hacer?: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1: agregar(); break;
                case 2: listar(); break;
                case 3: editar(); break;
                case 4: eliminar(); break;
            }
        } while (opcion != 5);
    }

    private static void agregar() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();

            Lector lector = new Lector(id, nombre, email);
            dao.insertar(lector);
            System.out.println("Lector agregado.");
        } catch (SQLException e) {
            System.out.println("Error al intentar agregar el lector: " + e.getMessage());
        }
    }

    private static void listar() {
        try {
            List<Lector> lista = dao.listar();
            System.out.println("Lista de Lectores:");
            for (Lector l : lista) {
                System.out.println(l.getId() + " - " + l.getNombre() + " - " + l.getEmail());
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar listar los lectores. " + e.getMessage());
        }
    }

    private static void editar() {
        try {
            System.out.print("ID del lector a editar: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Su nuevo nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Su nuevo email: ");
            String email = sc.nextLine();

            Lector lector = new Lector(id, nombre, email);
            dao.actualizar(lector);
            System.out.println("Lector actualizado.");
        } catch (SQLException e) {
            System.out.println("Error al intentar editar el lector. " + e.getMessage());
        }
    }

    private static void eliminar() {
        try {
            System.out.print("ID del lector a eliminar: ");
            int id = Integer.parseInt(sc.nextLine());
            dao.eliminar(id);
            System.out.println("Lector eliminado.");
        } catch (SQLException e) {
            System.out.println("Error al intentar eliminar al lector: " + e.getMessage());
        }
    }
}

