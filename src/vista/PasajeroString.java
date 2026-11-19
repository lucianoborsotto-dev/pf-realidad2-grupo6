package vista;

import modelo.Pasajero;

/* Esta clase fue hecha para tener otro toString para la clase Pasajero.*/
public class PasajeroString {
    private Pasajero pasajero;

    public PasajeroString(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    @Override
    public String toString() {
        return pasajero.getDni() + " - " + pasajero.getNombre() + " " + pasajero.getApellido();
    }
}
