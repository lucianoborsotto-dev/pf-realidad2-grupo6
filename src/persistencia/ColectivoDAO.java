package persistencia;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            }
            return true;
        }
    }
}
