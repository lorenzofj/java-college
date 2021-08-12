package DTO;

public class DTOreporte {
    public int cantidadServicios;
    public float totalImportePorCadaServicio;

    public DTOreporte(int cantidadServicios) {
        this.cantidadServicios = cantidadServicios;
    }

    public DTOreporte(float totalImportePorCadaServicio) {
        this.totalImportePorCadaServicio = totalImportePorCadaServicio;
    }

    public int getCantidadServicios() {
        return cantidadServicios;
    }

    public void setCantidadServicios(int cantidadServicios) {
        this.cantidadServicios = cantidadServicios;
    }

    public float getTotalImportePorCadaServicio() {
        return totalImportePorCadaServicio;
    }

    public void setTotalImportePorCadaServicio(float totalImportePorCadaServicio) {
        this.totalImportePorCadaServicio = totalImportePorCadaServicio;
    }
    
    
}
