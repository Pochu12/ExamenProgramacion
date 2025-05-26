package modelo;

import java.sql.*;
import java.util.*;

// Clase DAO donde gestionamos las operaciones SQL relacionadas a los lectores.
public class LectorDAO {

    // Método para insertar un nuevo lector
    public void insertar(Lector lector) throws SQLException {
        String sql = "INSERT INTO lectores (id, nombre, email) VALUES (?, ?, ?)";
        try (Connection con = ConexionBD.getConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, lector.getId());
            stmt.setString(2, lector.getNombre());
            stmt.setString(3, lector.getEmail());
            stmt.executeUpdate();
        }
    }

    // Método para actualizar los datos de un lector
    public void actualizar(Lector lector) throws SQLException {
        String sql = "UPDATE lectores SET nombre = ?, email = ? WHERE id = ?";
        try (Connection con = ConexionBD.getConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, lector.getNombre());
            stmt.setString(2, lector.getEmail());
            stmt.setInt(3, lector.getId());
            stmt.executeUpdate();
        }
    }

    // Método para eliminar un lector por su ID
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM lectores WHERE id = ?";
        try (Connection con = ConexionBD.getConexion(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método para listar todos los lectores de la base de datos
    public List<Lector> listar() throws SQLException {
        List<Lector> lista = new ArrayList<>();
        String sql = "SELECT * FROM lectores";
        try (Connection con = ConexionBD.getConexion(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Lector l = new Lector(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("email")
                );
                lista.add(l);
            }
        }
        return lista;
    }
}

