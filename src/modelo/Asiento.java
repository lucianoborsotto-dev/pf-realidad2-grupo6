package modelo;

public class Asiento {

    private int idAsiento;
    private Colectivo colectivo;
    private int numeroAsiento;
    private boolean estado = true;

    public Asiento() {
    }

    public Asiento(int idAsiento, Colectivo colectivo, int numeroAsiento, boolean estado) {
        this.idAsiento = idAsiento;
        this.colectivo = colectivo;
        this.numeroAsiento = numeroAsiento;
        this.estado = estado;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
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
}
