package Dto;

public class DtoListadoLibros {
    public String descripcion;
    public String nombreAutor;
    public String nacionalidad;

    public DtoListadoLibros(String descripcion, String nombreAutor, String nacionalidad) {
        this.descripcion = descripcion;
        this.nombreAutor = nombreAutor;
        this.nacionalidad = nacionalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "descripcion= " + descripcion + ", nombreAutor= " + nombreAutor + ", nacionalidad= " + nacionalidad;
    }
    
}
