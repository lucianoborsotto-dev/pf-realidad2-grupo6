package persistencia;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.RutaViaje;
import org.mariadb.jdbc.Statement;

public class RutaViajeDAO {

    private Connection con;

    public RutaViajeDAO() throws SQLException, ClassNotFoundException {
        con = Conexion.conectar();
    }

    public boolean insertar(RutaViaje ruta) throws SQLException {
        String sql = "INSERT INTO rutas "
                + "(origen, destino, fecha_viaje, hora_salida, hora_llegada, id_colectivo, precio, estado)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setDate(3, Date.valueOf(ruta.getFechaViaje()));
            ps.setTime(4, Time.valueOf(ruta.getHoraSalida()));
            ps.setTime(5, Time.valueOf(ruta.getHoraLlegada()));
            ps.setInt(6, ruta.getColectivo().getIdColectivo());
            ps.setBigDecimal(7, ruta.getPrecio());
            ps.setBoolean(8, ruta.isEstado());

            if (ps.executeUpdate() != 1) {
                return false;
            }

            try (ResultSet claves = ps.getGeneratedKeys()) {
                if (claves.next()) {
                    ruta.setIdRuta(claves.getInt(1));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return true;
    }

    public List<RutaViaje> listarRutas() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM rutas";
        List<RutaViaje> rutas = new ArrayList<>();
        try (
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                rutas.add(leerRuta(rs));
            }
        }
        return rutas;
    }

    private RutaViaje leerRuta(ResultSet rs) throws SQLException, ClassNotFoundException {

        ColectivoDAO cd = new ColectivoDAO();

        boolean estado = false;
        int estadoRs = rs.getInt("estado");

        if (estadoRs == 1) {
            estado = true;
        }

        return new RutaViaje(
                rs.getInt("id_ruta"),
                rs.getString("origen"),
                rs.getString("destino"),
                rs.getDate("fecha_viaje").toLocalDate(),
                rs.getTime("hora_salida").toLocalTime(),
                rs.getTime("hora_llegada").toLocalTime(),
                cd.buscarColectivoId(rs.getInt("id_colectivo")),
                rs.getBigDecimal("precio"),
                estado
        );
    }

    /**
     * Método para modificar las rutas
     */
    public void actualizarRuta(RutaViaje r) {
        String sql = "UPDATE rutas SET origen = ?, destino = ?, fecha_viaje = ?, hora_salida = ?, hora_llegada = ?, id_colectivo = ?, precio = ?, estado = ? WHERE id_ruta = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, r.getOrigen());
            ps.setString(2, r.getDestino());
            ps.setDate(3, Date.valueOf(r.getFechaViaje()));
            ps.setTime(4, Time.valueOf(r.getHoraSalida()));
            ps.setTime(5, Time.valueOf(r.getHoraLlegada()));
            ps.setInt(6, r.getColectivo().getIdColectivo());
            ps.setBigDecimal(7, r.getPrecio());
            ps.setBoolean(8, r.isEstado());
            ps.setInt(9, r.getIdRuta());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("No se pudo actualizar la ruta");
        }
    }
}
