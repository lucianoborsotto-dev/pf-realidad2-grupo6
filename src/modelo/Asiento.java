package modelo;

public class Asiento {
    private int idAsiento;

    private int idColectivo;

    private int numeroAsiento;

    private boolean estado = true;

    public Asiento() { }

    public Asiento(int idAsiento, int idColectivo, int numeroAsiento, boolean estado) {
        this.idAsiento = idAsiento;
        this.idColectivo = idColectivo;
        this.numeroAsiento = numeroAsiento;
        this.estado = estado;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public int getIdColectivo() {
        return idColectivo;
    }

    public void setIdColectivo(int idColectivo) {
        this.idColectivo = idColectivo;
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
