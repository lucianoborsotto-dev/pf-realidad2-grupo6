package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class RutaViaje {

    private int idRuta;
    private String origen;
    private String destino;
    private LocalDate fechaViaje;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private Colectivo colectivo;
    private BigDecimal precio;
    private boolean estado;

    public RutaViaje() {
    }

    public RutaViaje(String origen, String destino, LocalDate fechaViaje, LocalTime horaSalida, LocalTime horaLlegada, Colectivo colectivo, BigDecimal precio, boolean estado) {
        this.origen = origen;
        this.destino = destino;
        this.fechaViaje = fechaViaje;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.colectivo = colectivo;
        this.precio = precio;
        this.estado = estado;
    }

    public RutaViaje(int idRuta, String origen, String destino, LocalDate fechaViaje, LocalTime horaSalida, LocalTime horaLlegada, Colectivo colectivo, BigDecimal precio, boolean estado) {
        this.idRuta = idRuta;
        this.origen = origen;
        this.destino = destino;
        this.fechaViaje = fechaViaje;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.colectivo = colectivo;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(LocalDate fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
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
        return "RutaViaje{" + "idRuta=" + idRuta + ", origen=" + origen + ", destino=" + destino + ", fechaViaje=" + fechaViaje + ", horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada + ", colectivo=" + colectivo + ", precio=" + precio + ", estado=" + estado + '}';
    }

}
