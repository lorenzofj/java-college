package DTO;

public class DTOreporte2 {

    public String prestacion;
    public int cantidad;


    public String getPrestacion() {
        return prestacion;
    }

    public void setPrestacion(String prestacion) {
        this.prestacion = prestacion;
    }

    public DTOreporte2(String prestacion, int cantidad) {
        this.prestacion = prestacion;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return prestacion + " - " + cantidad;
    }
    
    
}
