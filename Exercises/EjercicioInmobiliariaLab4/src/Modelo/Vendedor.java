package Modelo;

public class Vendedor {
    private int idVendedor;
    private String nombreCompleto;

    public Vendedor(int idVendedor, String nombreCompleto) {
        this.idVendedor = idVendedor;
        this.nombreCompleto = nombreCompleto;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return nombreCompleto;
    }
    
    
}
