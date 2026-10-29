package persistencia;

import conexion.Conexion;
import modelo.Pasajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/* Operaciones de acceso a la tabla pasajeros de la base flechaflash */
public class PasajeroDAO {

    private Connection con;

    public PasajeroDAO() throws SQLException, ClassNotFoundException {
        con = Conexion.conectar();

    }

    // Requiere que pasajeros.id_pasajero sea autoincremental
    public boolean insertar(Pasajero pasajero) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO pasajeros "
                + "(dni, nombre, apellido, correo, telefono, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, pasajero.getDni());
            ps.setString(2, pasajero.getNombre());
            ps.setString(3, pasajero.getApellido());
            ps.setString(4, pasajero.getCorreo());
            ps.setString(5, pasajero.getTelefono());
            ps.setBoolean(6, pasajero.isEstado());

            if (ps.executeUpdate() != 1) {
                return false;
            }
            try (ResultSet claves = ps.getGeneratedKeys()) {
                if (claves.next()) {
                    pasajero.setIdPasajero(claves.getInt(1));
                }
            }
            return true;
        }
    }

    // Incluye pasajeros activos e inactivos.
    public List<Pasajero> listar() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * "
                + "FROM pasajeros ORDER BY id_pasajero";
        List<Pasajero> pasajeros = new ArrayList<>();
        try (
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                pasajeros.add(leerPasajero(rs));
            }
        }
        return pasajeros;
    }

    public Pasajero buscarPorId(int idPasajero) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * "
                + "FROM pasajeros WHERE id_pasajero = ?";
        try (
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPasajero);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? leerPasajero(rs) : null;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public boolean actualizar(Pasajero pasajero) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE pasajeros SET dni = ?, nombre = ?, apellido = ?, "
                + "correo = ?, telefono = ?, estado = ? WHERE id_pasajero = ?";
        try (
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pasajero.getDni());
            ps.setString(2, pasajero.getNombre());
            ps.setString(3, pasajero.getApellido());
            ps.setString(4, pasajero.getCorreo());
            ps.setString(5, pasajero.getTelefono());
            ps.setBoolean(6, pasajero.isEstado());
            ps.setInt(7, pasajero.getIdPasajero());
            return ps.executeUpdate() == 1;
        }
    }

    // Baja lógica: conserva el registro y sus pasajes relacionados.
    public boolean darDeBaja(int idPasajero) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE pasajeros SET estado = 0 "
                + "WHERE id_pasajero = ? AND estado <> 0";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPasajero);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean reactivar(int idPasajero) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE pasajeros SET estado = 1 "
                + "WHERE id_pasajero = ? AND estado = 0";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPasajero);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private Pasajero leerPasajero(ResultSet rs) throws SQLException {
        return new Pasajero(
                rs.getInt("id_pasajero"),
                rs.getString("dni"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("correo"),
                rs.getString("telefono"),
                rs.getBoolean("estado")
        );
    }
}
