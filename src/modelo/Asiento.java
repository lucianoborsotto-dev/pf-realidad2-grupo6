package modelo;

public class Asiento {

    private int idAsiento;
    private RutaViaje ruta;
    private int numeroAsiento;
    private boolean estado = true;

    public Asiento() {
    }

    public Asiento(int idAsiento, RutaViaje ruta, int numeroAsiento) {
        this.idAsiento = idAsiento;
        this.ruta = ruta;
        this.numeroAsiento = numeroAsiento;
    }

    public Asiento(RutaViaje ruta, int numeroAsiento) {
        this.ruta = ruta;
        this.numeroAsiento = numeroAsiento;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public RutaViaje getRuta() {
        return ruta;
    }

    public void setRuta(RutaViaje ruta) {
        this.ruta = ruta;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Asiento{" + "idAsiento=" + idAsiento + ", ruta=" + ruta + ", numeroAsiento=" + numeroAsiento + ", estado=" + estado + '}';
    }

}
