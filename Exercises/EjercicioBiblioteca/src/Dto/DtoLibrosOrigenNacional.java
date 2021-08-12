package Dto;

public class DtoLibrosOrigenNacional {
    public int id;
    public String descripcion;
    public String nombreAutor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public DtoLibrosOrigenNacional(int id, String descripcion, String nombreAutor) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombreAutor = nombreAutor;
    }

    @Override
    public String toString() {
        return "id= " + id + ", descripcion= " + descripcion + ", nombreAutor= " + nombreAutor;
    } 
}
