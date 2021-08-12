package DTO;

public class DTOreporte {
    public String fecha;
    public String nombreCompleto;
    public String tituloLibro;
    public int tipoLibro;

    public DTOreporte(String fecha, String nombreCompleto, String tituloLibro, int tipoLibro) {
        this.fecha = fecha;
        this.nombreCompleto = nombreCompleto;
        this.tituloLibro = tituloLibro;
        this.tipoLibro = tipoLibro;
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

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public int getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(int tipoLibro) {
        this.tipoLibro = tipoLibro;
    }
    
    
}
