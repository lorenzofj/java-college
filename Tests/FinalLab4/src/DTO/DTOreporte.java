package DTO;

public class DTOreporte {
    public String prestacion;
    public float costo;

    public DTOreporte(String prestacion, float costo) {
        this.prestacion = prestacion;
        this.costo = costo;
    }

    public String getPrestacion() {
        return prestacion;
    }

    public void setPrestacion(String prestacion) {
        this.prestacion = prestacion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return prestacion + " - " + costo;
    }   
}
