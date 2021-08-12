package Modelo;

public class Transaccion {
    private int idTransaccion;
    private String fecha;
    private int idVendedor;
    private int tipoOperacion;
    private int tipoInmueble;
    private float monto;

    public Transaccion(int idTransaccion, String fecha, int idVendedor, int tipoOperacion, int tipoInmueble, float monto) {
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.idVendedor = idVendedor;
        this.tipoOperacion = tipoOperacion;
        this.tipoInmueble = tipoInmueble;
        this.monto = monto;
    }

    public Transaccion(String fecha, int idVendedor, int tipoOperacion, int tipoInmueble, float monto) {
        this.fecha = fecha;
        this.idVendedor = idVendedor;
        this.tipoOperacion = tipoOperacion;
        this.tipoInmueble = tipoInmueble;
        this.monto = monto;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(int tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(int tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Transaccion " + idTransaccion + " :fecha = " + fecha + ", idVendedor = " + idVendedor + ", tipoOperacion = " + tipoOperacion + ", tipoInmueble = " + tipoInmueble + ", monto = " + monto;
    }
    
    
}
