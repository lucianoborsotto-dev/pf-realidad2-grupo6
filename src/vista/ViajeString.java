package vista;

import modelo.RutaViaje;

/* Esta clase fue hecha para tener otro toString para la clase RutaViaje.*/
public class ViajeString {
    private RutaViaje viaje;

    public ViajeString(RutaViaje viaje) {
        this.viaje = viaje;
    }

    public RutaViaje getViaje() {
        return viaje;
    }

    @Override
    public String toString() {
        return viaje.getOrigen() + "-" + viaje.getDestino() + "   " + viaje.getHoraSalida() + "h-" + viaje.getHoraLlegada() + "h";
    }
}
