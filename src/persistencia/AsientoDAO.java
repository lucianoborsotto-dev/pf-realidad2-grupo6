package persistencia;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Asiento;

public class AsientoDAO {
    
    private Connection con;
    
    public AsientoDAO() {
        try {
            con = Conexion.conectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException x) {
            JOptionPane.showMessageDialog(null, "Error al cargar los drivers", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void guardarAsiento(Asiento a) {
        String sql = "INSERT INTO lugar (id_viaje, NumeroAsiento, Estado) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, a.getColectivo());
        } catch (Exception e) {
        }
    }
    
}
