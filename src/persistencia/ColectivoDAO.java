package persistencia;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Colectivo;

public class ColectivoDAO {

    private Connection con;

    public ColectivoDAO() throws SQLException, ClassNotFoundException {
        con = Conexion.conectar();
    }

    public boolean insertar(Colectivo colectivo) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO colectivos "
                + "(matricula, marca, modelo, capacidad, chofer, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, colectivo.getMatricula());
            ps.setString(2, colectivo.getMarca());
            ps.setString(3, colectivo.getModelo());
            ps.setInt(4, colectivo.getCapacidad());
            ps.setString(5, colectivo.getChofer());
            ps.setBoolean(6, colectivo.isEstado());

            if (ps.executeUpdate() != 1) {
                return false;
            }
            try (ResultSet claves = ps.getGeneratedKeys()) {
                if (claves.next()) {
                    colectivo.setIdColectivo(claves.getInt(1));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            return true;
        }
    }

    public List<Colectivo> listarColectivos() throws SQLException {
        String sql = "SELECT * FROM colectivos";
        List<Colectivo> colectivos = new ArrayList<>();
        try (
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                colectivos.add(leerColectivo(rs));
            }
        }
        return colectivos;
    }

    public Colectivo buscarColectivoId(int id) throws SQLException {
        String sql = "SELECT * "
                + "FROM colectivos WHERE id_colectivo = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? leerColectivo(rs) : null;
            }
        }
    }

    private Colectivo leerColectivo(ResultSet rs) throws SQLException {

        boolean estado = false;
        int estadoRs = rs.getInt("estado");

        if (estadoRs == 1) {
            estado = true;
        }

        return new Colectivo(
                rs.getInt("id_colectivo"),
                rs.getString("matricula"),
                rs.getString("marca"),
                rs.getString("modelo"),
                rs.getInt("capacidad"),
                rs.getString("chofer"),
                estado
        );
    }
    
    
}
