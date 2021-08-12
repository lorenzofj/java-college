package Modelo;

public class Produccion {
    private int idProduccion;
    private int idResponsable;
    private String fecha;
    private int idComponente;
    private int cantidadProduccion;

    public Produccion(int idProduccion, int idResponsable, String fecha, int idComponente, int cantidadProduccion) {
        this.idProduccion = idProduccion;
        this.idResponsable = idResponsable;
        this.fecha = fecha;
        this.idComponente = idComponente;
        this.cantidadProduccion = cantidadProduccion;
    }

    public Produccion(int idResponsable, String fecha, int idComponente, int cantidadProduccion) {
        this.idResponsable = idResponsable;
        this.fecha = fecha;
        this.idComponente = idComponente;
        this.cantidadProduccion = cantidadProduccion;
    }

    public Produccion(int idProduccion, String fecha, int cantidadProduccion) {
        this.idProduccion = idProduccion;
        this.fecha = fecha;
        this.cantidadProduccion = cantidadProduccion;
    }

    public int getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }

    public int getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(int idComponente) {
        this.idComponente = idComponente;
    }

    public int getCantidadProduccion() {
        return cantidadProduccion;
    }

    public void setCantidadProduccion(int cantidadProduccion) {
        this.cantidadProduccion = cantidadProduccion;
    }

    @Override
    public String toString() {
        return "Produccion nro: "+ idProduccion + ", idResponsable = " + idResponsable + ", fecha = " + fecha + ", idComponente = " + idComponente + ", cantidadProduccion = " + cantidadProduccion;
    } 
}
