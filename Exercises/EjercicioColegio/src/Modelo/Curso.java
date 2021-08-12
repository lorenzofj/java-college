package Modelo;

public class Curso {
   private int idCurso;
   private String nombreCurso;
   private String turno;
   private int cupoMax;

    public Curso(int idCurso, String nombreCurso, String turno, int cupoMax) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.turno = turno;
        this.cupoMax = cupoMax;
    }

    public Curso(String nombreCurso, String turno, int cupoMax) {
        this.nombreCurso = nombreCurso;
        this.turno = turno;
        this.cupoMax = cupoMax;
    }

    public Curso(int idCurso, String nombreCurso) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getCupoMax() {
        return cupoMax;
    }

    public void setCupoMax(int cupoMax) {
        this.cupoMax = cupoMax;
    }

    @Override
    public String toString() {
        return nombreCurso;
    }  
}
