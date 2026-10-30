package modelo;

public class Lugar {

    private int idLugar;
    private RutaViaje ruta;
    private int numeroAsiento;
    private boolean estado;

    public Lugar() {
    }

    public Lugar(int idLugar, RutaViaje ruta, int numeroAsiento, boolean estado) {
        this.idLugar = idLugar;
        this.ruta = ruta;
        this.numeroAsiento = numeroAsiento;
        this.estado = estado;
    }

    public Lugar(RutaViaje ruta, int numeroAsiento, boolean estado) {
        this.ruta = ruta;
        this.numeroAsiento = numeroAsiento;
        this.estado = estado;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public void setRuta(RutaViaje ruta) {
        this.ruta = ruta;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public RutaViaje getRuta() {
        return ruta;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public boolean isEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Lugar{" + "idLugar=" + idLugar + ", ruta=" + ruta + ", numeroAsiento=" + numeroAsiento + ", estado=" + estado + '}';
    }
}
