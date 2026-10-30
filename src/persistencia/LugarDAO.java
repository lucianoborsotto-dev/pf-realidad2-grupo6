package persistencia;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Lugar;

public class LugarDAO {

    private Connection con;

    public LugarDAO() throws SQLException, ClassNotFoundException {
        con = Conexion.conectar();
    }
}

public Asiento buscarPorId(int asiento) throws SQLExeption{

}
    
