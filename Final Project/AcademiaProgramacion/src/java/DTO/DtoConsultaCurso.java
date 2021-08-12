package DTO;

public class DtoConsultaCurso {
    private int idCurso;
    private String nombreCurso;
    private String nombreAula;
    private int porcentaje;
    private float precio;

    public DtoConsultaCurso(int idCurso, String nombreCurso, String nombreAula, int porcentaje, float precio) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.nombreAula = nombreAula;
        this.porcentaje = porcentaje;
        this.precio = precio;
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

    public String getNombreAula() {
        return nombreAula;
    }

    public void setNombreAula(String nombreAula) {
        this.nombreAula = nombreAula;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
