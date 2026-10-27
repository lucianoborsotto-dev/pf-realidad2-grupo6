package persistencia;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
            }
        }
        return true;
    }

}
