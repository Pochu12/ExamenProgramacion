package modelo;

// Clase POJO para representar un lector registrado en la biblioteca.
public class Lector {
    private int id;
    private String nombre;
    private String email;

    // Constructor vacío
    public Lector() {}

    // Constructor con todos los campos
    public Lector(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

