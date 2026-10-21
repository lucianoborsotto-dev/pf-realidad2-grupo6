
package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/* Entidad Pasaje. La columna generada reserva_activa NO se asigna desde Java */
public class Pasaje {
    private int idPasaje;

    private int idPasajero;

    private int idLugar;

    private int idRuta;

    private int idColectivo;

    private LocalDate fechaVenta;

    private LocalTime horaVenta;

    private BigDecimal precio;

    private boolean estado = true;

    public Pasaje() { }

    public Pasaje(int idPasaje, int idPasajero, int idLugar, int idRuta, int idColectivo, LocalDate fechaVenta, LocalTime horaVenta, BigDecimal precio, boolean estado) {
        this.idPasaje = idPasaje;
        this.idPasajero = idPasajero;
        this.idLugar = idLugar;
        this.idRuta = idRuta;
        this.idColectivo = idColectivo;
        this.fechaVenta = fechaVenta;
        this.horaVenta = horaVenta;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public int getIdColectivo() {
        return idColectivo;
    }

    public void setIdColectivo(int idColectivo) {
        this.idColectivo = idColectivo;
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
}
