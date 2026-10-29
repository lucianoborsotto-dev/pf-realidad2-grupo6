package flechaflash;

import conexion.Conexion;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import persistencia.PasajeroDAO;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import modelo.Colectivo;
import modelo.RutaViaje;
import persistencia.ColectivoDAO;
import persistencia.RutaViajeDAO;

public class FlechaFlash {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        try {

//            Colectivo c = new Colectivo(1 ,"AAA444", "CHEVROLET", "16PROMAX", 46, "CHIQUI TAPIA", true);
//            ColectivoDAO cd = new ColectivoDAO();
//            cd.insertar(c);
//            cd.actualizar(c);
            
//            RutaViaje r = new RutaViaje(6, "Vos", "A mi casa",  LocalTime.of(10, 30), LocalTime.of(11, 00), c, BigDecimal.valueOf(2.33), true);
            RutaViajeDAO rd = new RutaViajeDAO();
//            rd.actualizarRuta(r);
//            rd.insertar(r);
            System.out.println(rd.buscarRuta(1));
            rd.altaBajaLogica(1, false);
//            System.out.println(rd.listarRutas());

//            PasajeroDAO pd = new PasajeroDAO();
//            System.out.println(pd.listar()); 

            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException x) {
            JOptionPane.showMessageDialog(null, "Error al cargar los drivers", "ERROR", JOptionPane.ERROR_MESSAGE);
        }        
    }
}
