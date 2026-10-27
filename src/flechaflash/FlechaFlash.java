package flechaflash;

import conexion.Conexion;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import modelo.Colectivo;
import modelo.RutaViaje;
import persistencia.RutaViajeDAO;

public class FlechaFlash {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        try {

            Colectivo c = new Colectivo(1,"AAA333", "VOLVO", "300X", 46, "Pablo Perez", true);
            RutaViaje r = new RutaViaje("San Luis", "Mendoza", LocalDate.of(2026, 10, 2), LocalTime.of(20, 30), LocalTime.of(23, 00), c, BigDecimal.valueOf(2.33), true);
            RutaViajeDAO rutaDAO = new RutaViajeDAO();
            rutaDAO.insertar(r);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException x) {
            JOptionPane.showMessageDialog(null, "Error al cargar los drivers", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
}
