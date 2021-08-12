package Dto;

public class DtoTransacciones {
    public String fecha;
    public String nombreCompleto;
    public String tipoOperacion;
    public String tipoInmueble;
    public float monto;

    public DtoTransacciones(String fecha, String nombreCompleto, String tipoOperacion, String tipoInmueble, float monto) {
        this.fecha = fecha;
        this.nombreCompleto = nombreCompleto;
        this.tipoOperacion = tipoOperacion;
        this.tipoInmueble = tipoInmueble;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "fecha= " + fecha + ", nombreCompleto= " + nombreCompleto + ", tipoOperacion= " + tipoOperacion + ", tipoInmueble= " + tipoInmueble + ", monto= " + monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
