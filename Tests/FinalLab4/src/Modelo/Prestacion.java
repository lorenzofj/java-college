package Modelo;

public class Prestacion {
    private int id;
    private String descripcion;
    private float monto;

    public Prestacion(String descripcion, float monto) {
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public Prestacion(int id, String descripcion, float monto) {
        this.id = id;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    
}
