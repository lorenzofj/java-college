package Modelo;

public class Prestamo {
    private int idPrestamo;
    private String tipo;

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Prestamo(int idPrestamo, String tipo) {
        this.idPrestamo = idPrestamo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
