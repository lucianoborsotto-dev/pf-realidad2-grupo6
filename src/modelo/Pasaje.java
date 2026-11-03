package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/* Entidad Pasaje. La columna generada reserva_activa NO se asigna desde Java */
public class Pasaje {

    private int idPasaje;

    private Pasajero pasajero;

    private Lugar asiento;

    private RutaViaje ruta;

    private Colectivo colectivo;

    private LocalDate fechaVenta;

    private LocalTime horaVenta;

    private BigDecimal precio;

    private boolean estado = true;

    public Pasaje() {
    }

    public Pasaje(int idPasaje, Pasajero pasajero, Lugar asiento, RutaViaje ruta, Colectivo colectivo, LocalDate fechaVenta, LocalTime horaVenta, BigDecimal precio) {
        this.idPasaje = idPasaje;
        this.pasajero = pasajero;
        this.asiento = asiento;
        this.ruta = ruta;
        this.colectivo = colectivo;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.precio = precio;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Lugar getAsiento() {
        return asiento;
    }

    public void setAsiento(Lugar asiento) {
        this.asiento = asiento;
    }

    public RutaViaje getRuta() {
        return ruta;
    }

    public void setRuta(RutaViaje ruta) {
        this.ruta = ruta;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public LocalTime getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(LocalTime horaVenta) {
        this.horaVenta = horaVenta;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pasaje{" + "idPasaje=" + idPasaje + ", pasajero=" + pasajero + ", asiento=" + asiento + ", ruta=" + ruta + ", colectivo=" + colectivo + ", fechaVenta=" + fechaVenta + ", horaVenta=" + horaVenta + ", precio=" + precio + ", estado=" + estado + '}';
    }

}
