package modelo;

public class Lugar {

    private int idAsiento;
    private RutaViaje ruta;
    private int numeroAsiento;
    private boolean estado = true;

    public Lugar() {
    }

    public Lugar(int idAsiento, RutaViaje ruta, int numeroAsiento) {
        this.idAsiento = idAsiento;
        this.ruta = ruta;
        this.numeroAsiento = numeroAsiento;
    }

    public Lugar(RutaViaje ruta, int numeroAsiento) {
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

    public int getColectivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
