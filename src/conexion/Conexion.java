package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost:3306/flechaflashh";
    private static final String USUARIO = "root";
    private static final String CLAVE = "";
    private static Connection connection;

    public Conexion() {
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        Conexion.connection = connection;
    }

    public static Connection conectar() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USUARIO, CLAVE);
        }
        return connection;
    }
}
