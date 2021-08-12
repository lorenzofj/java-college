package Modelo;

public class Prestamo {
    private int id;
    private String fechaPrestamo;
    private int legajoAlumno;
    private String tituloLibro;
    private int tematicaLibro;
    private int tipoLibro;

    public Prestamo(String fechaPrestamo, int legajoAlumno, String tituloLibro, int tematicaLibro, int tipoLibro) {
        this.fechaPrestamo = fechaPrestamo;
        this.legajoAlumno = legajoAlumno;
        this.tituloLibro = tituloLibro;
        this.tematicaLibro = tematicaLibro;
        this.tipoLibro = tipoLibro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getLegajoAlumno() {
        return legajoAlumno;
    }

    public void setLegajoAlumno(int legajoAlumno) {
        this.legajoAlumno = legajoAlumno;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public int getTematicaLibro() {
        return tematicaLibro;
    }

    public void setTematicaLibro(int tematicaLibro) {
        this.tematicaLibro = tematicaLibro;
    }

    public int getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(int tipoLibro) {
        this.tipoLibro = tipoLibro;
    }
    
    
}
