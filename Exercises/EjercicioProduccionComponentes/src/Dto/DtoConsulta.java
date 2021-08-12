package Dto;

public class DtoConsulta {
    public String nombre;
    public float cantidad;

    public DtoConsulta(String nombre, float cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Nombre = " + nombre + ", Total = " + cantidad;
    }  
}
