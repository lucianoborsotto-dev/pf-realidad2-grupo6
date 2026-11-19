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
import modelo.Lugar;
import modelo.Pasaje;
import modelo.Pasajero;
import modelo.RutaViaje;
import org.mariadb.jdbc.Statement;

public class PasajeDAO {

    private Connection con;

    public PasajeDAO() throws SQLException, ClassNotFoundException {
        con = Conexion.conectar();
    }

    //Metodos
    public boolean generar(Pasaje pasaje) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO pasajes (id_pasajero, id_lugar, ID_Ruta, fechaVenta, horaVenta, precio, estado)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, pasaje.getPasajero().getIdPasajero());
            ps.setInt(2, pasaje.getAsiento().getIdLugar());
            ps.setInt(3, pasaje.getRuta().getIdRuta());
            ps.setDate(4, Date.valueOf(pasaje.getFechaVenta()));
            ps.setTime(5, Time.valueOf(pasaje.getHoraVenta()));
            ps.setBigDecimal(6, pasaje.getPrecio());
            ps.setBoolean(7, pasaje.isEstado());

            if (ps.executeUpdate() != 1) {
                return false;
            }

            try (ResultSet claves = ps.getGeneratedKeys()) {
                if (claves.next()) {
                    pasaje.setIdPasaje(claves.getInt(1));
                }
            }
        }
        return true;
    }

    public void borrarPasaje(int idPasajero) throws SQLException, ClassNotFoundException {
        PasajeroDAO pd = new PasajeroDAO();
        Pasajero p = pd.buscarPorId(idPasajero);

        String sql = "DELETE FROM pasajes WHERE ID_Pasajero = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, p.getIdPasajero());
            ps.executeUpdate();

            System.out.println("Pasaje eliminado correctamente");
        } catch (SQLException ex) {
            System.out.println("No se pudo eliminar el pasaje");
        }
    }
    
    public void borrarPorLugarYViaje(int idLugar, int idViaje) throws SQLException {
        String sql = "DELETE FROM pasajes WHERE ID_Lugar = ? AND ID_Ruta = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLugar);
            ps.setInt(2, idViaje);
            ps.executeUpdate();
        }
    }

    public void borrarPasajeV(int idViaje) {
        try {
            RutaViajeDAO rtv = new RutaViajeDAO();
            RutaViaje rv = rtv.buscarRuta(idViaje);

            String sql = "DELETE FROM pasajes WHERE ID_Viaje = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rv.getIdRuta());
            ps.executeUpdate();
            System.out.println("Ruta eliminada correctamente");

        } catch (SQLException ex) {
            System.out.println("No se pudo borrar el pasaje");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se pudo establecer conexion");
        }
    }

    public List<Pasaje> listarPasajes() throws SQLException, ClassNotFoundException {
        Pasaje p = null;
        Pasajero pasa = null;
        Lugar l = null;
        RutaViaje rv = null;

        PasajeroDAO pd = new PasajeroDAO();
        LugarDAO ld = new LugarDAO();
        RutaViajeDAO rvd = new RutaViajeDAO();

        ArrayList<Pasaje> listaPasaje = new ArrayList<>();
        String sql = "SELECT * FROM pasajes";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Pasaje();
                p.setIdPasaje(rs.getInt(1));
                p.setPasajero(pd.buscarPorId(rs.getInt(2)));
                p.setAsiento(ld.buscarPorId(rs.getInt(3)));
                p.setRuta(rvd.buscarRuta(rs.getInt(4)));
                p.setFechaVenta(rs.getDate("FechaVenta").toLocalDate());
                p.setHoraVenta(rs.getTime("HoraVenta").toLocalTime());
                p.setPrecio(rs.getBigDecimal("Precio"));
                p.setEstado(rs.getBoolean("Estado"));

                listaPasaje.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al hacer la consulta");
        }
        return listaPasaje;
    }
}
