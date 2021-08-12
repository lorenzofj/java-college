package Modelo;

public class Alumno {
    private int idAlumno;
    private String nombreApellido;
    private int tituloNivelMedio;
    private int idCurso;

    public Alumno(int idAlumno, String nombreApellido, int tituloNivelMedio, int idCurso) {
        this.idAlumno = idAlumno;
        this.nombreApellido = nombreApellido;
        this.tituloNivelMedio = tituloNivelMedio;
        this.idCurso = idCurso;
    }

    public Alumno(String nombreApellido, int tituloNivelMedio, int idCurso) {
        this.nombreApellido = nombreApellido;
        this.tituloNivelMedio = tituloNivelMedio;
        this.idCurso = idCurso;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public int getTituloNivelMedio() {
        return tituloNivelMedio;
    }

    public void setTituloNivelMedio(int tituloNivelMedio) {
        this.tituloNivelMedio = tituloNivelMedio;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public String toString() {
        return "Alumno= " + idAlumno + ", nombreApellido=" + nombreApellido + ", tituloNivelMedio=" + tituloNivelMedio + ", idCurso=" + idCurso + '}';
    } 
}
