package Modelo;

public class Titulo {
    private int idTitulo;
    private String titulo;

    public Titulo(int idTitulo, String titulo) {
        this.idTitulo = idTitulo;
        this.titulo = titulo;
    }

    public int getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(int idTitulo) {
        this.idTitulo = idTitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return titulo;
    }
    
    
}
