package flechaflash;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import persistencia.PasajeroDAO;


public class FlechaFlash {

    public static void main(String[] args) {

        try (Connection con = Conexion.conectar()) {

            System.out.println("Conexion exitosa con MariaDB");
            System.out.println("Base de datos: flechaflash");

            PasajeroDAO pd = new PasajeroDAO();
            System.out.println(pd.listar()); 
            
        } catch (SQLException e) {

            System.out.println("Error de conexion:");
            System.out.println(e.getMessage());

        }
        
    }
}