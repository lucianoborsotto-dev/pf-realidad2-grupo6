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
import modelo.Lugar;
import modelo.RutaViaje;
import org.mariadb.jdbc.Statement;

public class RutaViajeDAO {

    private Connection con;

    public RutaViajeDAO() throws SQLException, ClassNotFoundException {
        con = Conexion.conectar();
    }

    public boolean insertar(RutaViaje ruta) {
        String sql = "INSERT INTO viaje "
                + "(origen, destino,  HoraSalida, HoraLlegada, id_colectivo, precio, estado)"
                + " VALUES (?, ?, ?,  ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setTime(3, Time.valueOf(ruta.getHoraSalida()));
            ps.setTime(4, Time.valueOf(ruta.getHoraLlegada()));
            ps.setInt(5, ruta.getColectivo().getIdColectivo());
            ps.setBigDecimal(6, ruta.getPrecio());
            ps.setBoolean(7, ruta.isEstado());

            if (ps.executeUpdate() != 1) {
                return false;
            }

            ResultSet claves = ps.getGeneratedKeys();
            if (claves.next()) {
                ruta.setIdRuta(claves.getInt(1));
            }

            int capacidadColectivo = ruta.getColectivo().getCapacidad();
            LugarDAO ld = new LugarDAO();
            for (int i = 1; i <= capacidadColectivo; i++) {
                Lugar lugar = new Lugar(ruta, i, true);
                ld.crear(lugar);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los drivers", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }

    public RutaViaje buscarRuta(int id) throws SQLException, ClassNotFoundException {
        RutaViaje rv = null;
        ColectivoDAO cd = new ColectivoDAO();
        String sql = "SELECT * FROM viaje WHERE ID_Viaje = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rv = new RutaViaje();
                rv.setIdRuta(rs.getInt("ID_Viaje"));
                rv.setOrigen(rs.getString("Origen"));
                rv.setDestino(rs.getString("Destino"));
                rv.setHoraSalida(rs.getTime("HoraSalida").toLocalTime());
                rv.setHoraLlegada(rs.getTime("HoraLlegada").toLocalTime());
                rv.setColectivo(cd.buscarColectivoId(rs.getInt("ID_Colectivo")));
                rv.setPrecio(rs.getBigDecimal("Precio"));
                rv.setEstado(rs.getBoolean("Estado"));
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo obtener la ruta");
        }
        return rv;
    }

    public List<RutaViaje> listarRutas() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM viaje";
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

    public List<RutaViaje> listarRutasT() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM viaje WHERE Estado = 1";
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
                rs.getInt("ID_Viaje"),
                rs.getString("Origen"),
                rs.getString("Destino"),
                rs.getTime("HoraSalida").toLocalTime(),
                rs.getTime("HoraLlegada").toLocalTime(),
                cd.buscarColectivoId(rs.getInt("ID_colectivo")),
                rs.getBigDecimal("Precio"),
                estado
        );
    }

    /**
     * Método para modificar las rutas
     */
    public void actualizarRuta(RutaViaje ruta) {
        String sql = "UPDATE viaje SET Origen = ?, Destino = ?, HoraSalida = ?, HoraLlegada = ?, ID_Colectivo = ?, Precio = ?, Estado = ? WHERE ID_Viaje = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setTime(3, Time.valueOf(ruta.getHoraSalida()));
            ps.setTime(4, Time.valueOf(ruta.getHoraLlegada()));
            ps.setInt(5, ruta.getColectivo().getIdColectivo());
            ps.setBigDecimal(6, ruta.getPrecio());
            ps.setBoolean(7, ruta.isEstado());
            ps.setInt(8, ruta.getIdRuta());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("No se pudo actualizar la ruta");
        }
    }

    public void borrarRuta(int id) {
        String sql = "DELETE FROM viaje WHERE ID_Viaje = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("No se pudo borrar la ruta");
        }
    }

    public void altaBajaLogica(int id, boolean estado) {
        try {
            RutaViaje rv = buscarRuta(id);
            rv.setEstado(estado);
            actualizarRuta(rv);
            System.out.println("se actualizo el estado de la ruta");
        } catch (SQLException ex) {
            System.out.println("No se pudo dar de baja el viaje");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al establecer cnexion");
        }
    }

    public void borrarRutaColectivo(int idColectivo) {

        String sql = "DELETE FROM viaje WHERE ID_Colectivo = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idColectivo);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("No se pudo borrar la ruta");
        }
    }
}
