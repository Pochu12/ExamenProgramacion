package modelo;

import java.sql.*;
import java.util.*;

// Clase DAO donde gestionamos las operaciones SQL relacionadas a los libros.
public class LibroDAO {

    // Método para poder insertar un nuevo libro.
    public void insertar(Libro libro) throws SQLException {
        String sql = "INSERT INTO libros (id, titulo, autor, anio_publicacion) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, libro.getId());
            stmt.setString(2, libro.getTitulo());
            stmt.setString(3, libro.getAutor());
            stmt.setInt(4, libro.getAnioPublicacion());
            stmt.executeUpdate();
        }
    }

    // Método para actualizar los datos de un libro
    public void actualizar(Libro libro) throws SQLException {
        String sql = "UPDATE libros SET titulo = ?, autor = ?, anio_publicacion = ? WHERE id = ?";
        try (Connection con = ConexionBD.getConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getAnioPublicacion());
            stmt.setInt(4, libro.getId());
            stmt.executeUpdate();
        }
    }

    // Método para eliminar un libro por su ID
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM libros WHERE id = ?";
        try (Connection con = ConexionBD.getConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método para listar todos los libros de la base de datos
    public List<Libro> listar() throws SQLException {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try (Connection con = ConexionBD.getConexion(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Libro l = new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("anio_publicacion")
                );
                lista.add(l);
            }
        }
        return lista;
    }
}
