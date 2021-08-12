package Modelo;

public class Autor {
    private int id_Autor;
    private String nombre;
    private String nacionalidad;

    public Autor(int id_Autor, String nombre, String nacionalidad) {
        this.id_Autor = id_Autor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public Autor(int id_Autor, String nombre) {
        this.id_Autor = id_Autor;
        this.nombre = nombre;
    }

    public int getId_Autor() {
        return id_Autor;
    }

    public void setId_Autor(int id_Autor) {
        this.id_Autor = id_Autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
