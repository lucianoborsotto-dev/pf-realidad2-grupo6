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

public class LugarDAO {

    private Connection con;

    public LugarDAO() throws SQLException, ClassNotFoundException {
        con = Conexion.conectar();
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

    public Lugar buscarPorId(int idLugar) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * "
                + "FROM lugar WHERE ID_lugar = ?";
        try (
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLugar);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? leerLugar(rs) : null;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public boolean actualizar(Lugar lugar) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE lugar SET id_lugar = ?, id_viaje = ?, numeroasiento = ?, estado = ?";
        try (
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, lugar.getIdLugar());
            ps.setInt(2, lugar.getRuta().getIdRuta());
            ps.setInt(3, lugar.getNumeroAsiento());
            ps.setBoolean(4, lugar.isEstado());
            return ps.executeUpdate() == 1;
        }
    }
    
    public void altaBajaLogica(int id, boolean estado) throws SQLException, ClassNotFoundException {
        Lugar rv = buscarPorId(id);
        rv.setEstado(estado);
        actualizar(rv);
        System.out.println("se actualizo el estado de la ruta");
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
