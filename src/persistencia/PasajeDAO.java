package persistencia;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import modelo.Lugar;
import modelo.Pasaje;
import org.mariadb.jdbc.Statement;

public class PasajeDAO {

    private Connection con;

    public PasajeDAO() throws SQLException, ClassNotFoundException {
        con = Conexion.conectar();
    }

    public boolean generar(Pasaje pasaje) throws SQLException, ClassNotFoundException {
        LocalTime horaActual = LocalTime.now();
        LocalTime horaSalida = pasaje.getRuta().getHoraSalida();

        if (!horaSalida.isAfter(horaActual)) {
            JOptionPane.showMessageDialog(null,
                    "no se puede comprar un pasaje para un viaje que ya salio",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //bussco el lugar por el id de pasaje.getAsiento
        LugarDAO ld = new LugarDAO();
        Lugar lugar = ld.buscarPorId(pasaje.getAsiento().getIdLugar());

        //si el lugar no existe tira error
        if (lugar == null) {
            JOptionPane.showMessageDialog(null,
                    "El lugar no existe en la base de datos.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //se fija que estado sea false, si es false, tira error
        if (lugar.isEstado() == false) {
            JOptionPane.showMessageDialog(null, "El lugar ya esta ocupado.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            //si no, cambia el estado del asiento a false
            lugar.setEstado(false);
            ld.actualizar(lugar);

            //y sigue
            String sql = "INSERT INTO pasajes (id_pasajero, id_lugar, id_ruta, fechaVenta, horaVenta, precio, estado)"
                    + " VALUES (?, ?, ?,  ?, ?, ?, ?)";

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
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            return true;
        }
    }
}
