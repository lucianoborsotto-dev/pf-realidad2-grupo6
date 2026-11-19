package persistencia;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Lugar;
import modelo.RutaViaje;
import org.mariadb.jdbc.Statement;

public class LugarDAO {

    private Connection con;

    public LugarDAO() throws SQLException, ClassNotFoundException {
        con = Conexion.conectar();
    }

    public boolean crear(Lugar lugar) throws SQLException {
        String sql = "INSERT INTO lugar (id_viaje, numeroAsiento, estado)"
                + " VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, lugar.getRuta().getIdRuta());
            ps.setInt(2, lugar.getNumeroAsiento());
            ps.setBoolean(3, lugar.isEstado());

            if (ps.executeUpdate() != 1) {
                return false;
            }

            try (ResultSet claves = ps.getGeneratedKeys()) {
                if (claves.next()) {
                    lugar.setIdLugar(claves.getInt(1));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return true;
    }

    public List<Lugar> listar() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * "
                + "FROM lugar ORDER BY ID_Lugar";
        List<Lugar> lugares = new ArrayList<>();
        try (
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lugares.add(leerLugar(rs));
            }
        }
        return lugares;
    }

    public List<Lugar> listarPorViaje(int idViaje) {
        String sql = "SELECT * FROM lugar WHERE ID_Viaje = ? ORDER BY NumeroAsiento";
        List<Lugar> lugares = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idViaje);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lugares.add(leerLugar(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error cargar los drivers", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return lugares;
    }

    public Lugar buscarPorId(int idLugar) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * "
                + "FROM lugar WHERE ID_lugar = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLugar);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? leerLugar(rs) : null;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public void borrarLugaresV(int idViaje) {
        try {
            RutaViajeDAO rtv = new RutaViajeDAO();
            RutaViaje rv = rtv.buscarRuta(idViaje);

            String sql = "DELETE FROM lugar WHERE ID_Viaje = ?"; // (SELECT ID_viaje FROM viaje WHERE ID_colectivo = ?)
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rv.getIdRuta());
            ps.executeUpdate();
            System.out.println("Ruta eliminada correctamente");

        } catch (SQLException ex) {
            System.out.println("No se pudo borrar los lugares");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se puedo establecer conexion");
        }
    }

    public void borrarLugaresPorColectivo(int idColectivo) {
        // Usamos una subconsulta para encontrar todos los viajes de ese colectivo y borrar sus lugares
        String sql = "DELETE FROM lugar WHERE ID_Viaje IN (SELECT ID_Viaje FROM viaje WHERE ID_Colectivo = ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idColectivo);
            int filasAfectadas = ps.executeUpdate();

            System.out.println("Se eliminaron " + filasAfectadas + " lugares asociados al colectivo ID: " + idColectivo);

        } catch (SQLException ex) {
            System.out.println("No se pudieron borrar los lugares del colectivo: " + ex.getMessage());
        }
    }

    public boolean actualizar(Lugar lugar) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE lugar SET id_viaje = ?, numeroasiento = ?, estado = ? WHERE id_lugar = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, lugar.getRuta().getIdRuta());
            ps.setInt(2, lugar.getNumeroAsiento());
            ps.setBoolean(3, lugar.isEstado());
            ps.setInt(4, lugar.getIdLugar());

            return ps.executeUpdate() == 1;
        }
    }

    public void altaBajaLogica(int idViaje, boolean estado) {
        String sql = "UPDATE lugar SET estado = ? WHERE ID_Viaje = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, estado);
            ps.setInt(2, idViaje);

            ps.executeUpdate();
            System.out.println("Se actualizó el estado de los lugares del viaje ID: " + idViaje);

        } catch (SQLException ex) {
            System.out.println("No se pudo dar de baja los asientos del viaje: " + ex.getMessage());
        }
    }

    public void altaBajaLogicaLugar(boolean estado, int idLugar, int idViaje) {
        String sql = "UPDATE lugar SET estado = ? WHERE ID_lugar = ? AND ID_viaje = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, estado);
            ps.setInt(2, idLugar);
            ps.setInt(3, idViaje);

            ps.executeUpdate();
            System.out.println("Se actualizó el estado de los lugares del viaje ID: " + idLugar);

        } catch (SQLException ex) {
            System.out.println("No se pudo dar de baja los asientos del viaje: " + ex.getMessage());
        }
    }

    private Lugar leerLugar(ResultSet rs) throws SQLException, ClassNotFoundException {

        RutaViajeDAO rd = new RutaViajeDAO();

        return new Lugar(
                rs.getInt("ID_Lugar"),
                rd.buscarRuta(rs.getInt("ID_Viaje")),
                rs.getInt("NumeroAsiento"),
                rs.getBoolean("Estado")
        );
    }
}
