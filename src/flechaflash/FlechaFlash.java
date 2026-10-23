package flechaflash;

import conexion.Conexion;
import modelo.Pasajero;
import persistencia.PasajeroDAO;
import java.sql.Connection;
import java.sql.SQLException;

public class FlechaFlash {

    public static void main(String[] args) {

        try (Connection con = Conexion.conectar()) {

            System.out.println("Conexion exitosa con MariaDB");
            System.out.println("Base de datos: flechaflash");

            // Crear pasajero de prueba
            Pasajero pasajero = new Pasajero(
                0,
                "99000001",
                "Juan",
                "Prueba",
                "prueba99000001@example.com",
                "2664000000",
                true
            );

            // Guardar en MariaDB
            PasajeroDAO dao = new PasajeroDAO();

            boolean guardado = dao.insertar(pasajero);

            if (guardado) {
                System.out.println("Pasajero guardado correctamente");
                System.out.println("ID generado: " + pasajero.getIdPasajero());

                Pasajero encontrado = dao.buscarPorId(pasajero.getIdPasajero());

                if (encontrado != null) {
                    System.out.println("Pasajero encontrado: "
                        + encontrado.getNombre() + " "
                        + encontrado.getApellido());
                }
            } else {
                System.out.println("No se pudo guardar el pasajero");
            }

        } catch (SQLException e) {
            System.out.println("Error:");
            System.out.println(e.getMessage());
        }
    }
}