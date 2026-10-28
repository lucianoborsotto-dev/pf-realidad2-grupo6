package flechaflash;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import modelo.Pasajero;
import persistencia.PasajeroDAO;

/** Prueba por consola del ABM de Pasajero para la primera entrega. */
public class TestPasajero {

    private static final Scanner ENTRADA = new Scanner(System.in);
    private static final PasajeroDAO DAO = new PasajeroDAO();

    public static void main(String[] args) throws ClassNotFoundException {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== FlechaFlash: ABM de pasajeros ===");
            System.out.println("1. Alta de pasajero");
            System.out.println("2. Buscar pasajero por ID");
            System.out.println("3. Modificar nombre de pasajero");
            System.out.println("4. Dar de baja pasajero (baja logica)");
            System.out.println("5. Listar pasajeros");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            String opcion = ENTRADA.nextLine().trim();

            try {
                switch (opcion) {
                    case "1": alta(); break;
                    case "2": buscar(); break;
                    case "3": modificar(); break;
                    case "4": baja(); break;
                    case "5": listar(); break;
                    case "0": continuar = false; break;
                    default: System.out.println("Opcion no valida.");
                }
            } catch (SQLException ex) {
                System.out.println("Error de base de datos: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("El ID debe ser un numero entero.");
            }
        }
    }

    private static void alta() throws SQLException, ClassNotFoundException {
        String dni = pedir("DNI: ");
        String nombre = pedir("Nombre: ");
        String apellido = pedir("Apellido: ");
        String correo = pedir("Correo: ");
        String telefono = pedir("Telefono: ");

        if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty()) {
            System.out.println("DNI, nombre, apellido y correo no pueden estar vacios.");
            return;
        }

        Pasajero nuevo = new Pasajero(0, dni, nombre, apellido, correo, telefono, true);
        if (DAO.insertar(nuevo)) {
            System.out.println("Alta correcta. ID: " + nuevo.getIdPasajero());
        } else {
            System.out.println("No se pudo dar de alta.");
        }
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = pedirId();
        mostrar(DAO.buscarPorId(id));
    }

    private static void modificar() throws SQLException, ClassNotFoundException {
        int id = pedirId();
        Pasajero pasajero = DAO.buscarPorId(id);
        if (pasajero == null) {
            System.out.println("No existe ese pasajero.");
            return;
        }
        mostrar(pasajero);
        String nuevoNombre = pedir("Nuevo nombre (Enter para conservar): ");
        if (nuevoNombre.isEmpty()) {
            System.out.println("No se realizaron cambios.");
            return;
        }
        pasajero.setNombre(nuevoNombre);
        System.out.println(DAO.actualizar(pasajero)
                ? "Modificacion correcta." : "No se pudo modificar.");
    }

    private static void baja() throws SQLException, ClassNotFoundException {
        int id = pedirId();
        Pasajero pasajero = DAO.buscarPorId(id);
        if (pasajero == null) {
            System.out.println("No existe ese pasajero.");
            return;
        }
        if (!pasajero.isEstado()) {
            System.out.println("El pasajero ya esta inactivo.");
            return;
        }
        mostrar(pasajero);
        if (!"SI".equalsIgnoreCase(pedir("Confirmar baja logica (SI): "))) {
            System.out.println("Operacion cancelada.");
            return;
        }
        boolean ok = DAO.darDeBaja(id);
        Pasajero resultado = DAO.buscarPorId(id);
        System.out.println(ok && resultado != null && !resultado.isEstado()
                ? "Baja logica correcta (estado = false)."
                : "No se pudo confirmar la baja.");
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        List<Pasajero> pasajeros = DAO.listar();
        if (pasajeros.isEmpty()) {
            System.out.println("No hay pasajeros registrados.");
        }
        for (Pasajero pasajero : pasajeros) {
            mostrar(pasajero);
        }
    }

    private static int pedirId() {
        return Integer.parseInt(pedir("ID del pasajero: "));
    }

    private static String pedir(String texto) {
        System.out.print(texto);
        return ENTRADA.nextLine().trim();
    }

    private static void mostrar(Pasajero p) {
        if (p == null) {
            System.out.println("Pasajero no encontrado.");
            return;
        }
        System.out.println("ID=" + p.getIdPasajero()
                + " | DNI=" + p.getDni()
                + " | " + p.getNombre() + " " + p.getApellido()
                + " | Correo=" + p.getCorreo()
                + " | Telefono=" + p.getTelefono()
                + " | Activo=" + p.isEstado());
    }
}
