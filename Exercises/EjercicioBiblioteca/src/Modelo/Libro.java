package Modelo;

public class Libro {
    private int idLibro;
    private String descripcion;
    private Prestamo prestamo;
    private Autor autor;

    public Libro(int idLibro, String descripcion, Prestamo prestamo, Autor autor) {
        this.idLibro = idLibro;
        this.descripcion = descripcion;
        this.prestamo = prestamo;
        this.autor = autor;
    }

    public Libro(String descripcion, Prestamo prestamo, Autor autor) {
        this.descripcion = descripcion;
        this.prestamo = prestamo;
        this.autor = autor;
    }

    public Libro(int idLibro, String descripcion) {
        this.idLibro = idLibro;
        this.descripcion = descripcion;
    }
    
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }
    
    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
}
