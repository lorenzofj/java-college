package Modelo;

public class Descuento {
   private int id;
   private int porcentaje;

    public Descuento(int id, int porcentaje) {
        this.id = id;
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
