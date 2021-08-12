package Dto;

public class DtoNombreAutor {
    public String nacionalidad;
    public String descripcion;
    public String tipoPrestamo;

    public DtoNombreAutor(String nacionalidad, String descripcion, String tipoPrestamo) {

        this.nacionalidad = nacionalidad;
        this.descripcion = descripcion;
        this.tipoPrestamo = tipoPrestamo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    @Override
    public String toString() {
        return "nacionalidad= " + nacionalidad + ", descripcion= " + descripcion + ", tipoPrestamo= " + tipoPrestamo;
    }
    
    
}
