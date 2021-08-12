package Modelo;

public class Curso {
    private int id;
    private String nombre;
    private Aula aula;
    private Descuento descuento;
    private float precio;

    public Curso(int id, String nombre, Aula aula, Descuento descuento, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.aula = aula;
        this.descuento = descuento;
        this.precio = precio;
    }

    public Curso(String nombre, Aula aula, Descuento descuento, float precio) {
        this.nombre = nombre;
        this.aula = aula;
        this.descuento = descuento;
        this.precio = precio;
    }

    public Curso(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
